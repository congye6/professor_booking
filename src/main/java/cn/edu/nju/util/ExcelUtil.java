package cn.edu.nju.util;

import cn.edu.nju.vo.MajorRankVO;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ExcelUtil {

    /**
     * 将Excel文件读取为json字符串组成的list
     *
     * @param path 文件路径
     * @return
     * @throws Exception
     */
    public <T> List<T> readXlsToJson(String path, Class<T> clazz) {
        List<List<String>> xlsList = readXls(path);

        List<T> result = new ArrayList<>();
        List<String> subjectList = xlsList.get(0);

        for (int i = 1; i < xlsList.size(); i++) {
            JSONObject jsonObject = new JSONObject(true);
            for (int j = 0; j < subjectList.size(); j++) {
                if (xlsList.get(i).size() <= j)//最后几行为空
                    jsonObject.put(subjectList.get(j), "");
                else
                    jsonObject.put(subjectList.get(j), xlsList.get(i).get(j));
//                System.out.println(jsonObject.toString());
            }
            result.add(JSONObject.parseObject(jsonObject.toString(), clazz));
        }

        return result;
    }

    public <T> List<T> readRankToJson(String path, Class<T> clazz) {
        List<List<String>> xlsList = readXls(path);

        List<T> result = new ArrayList<>();
        List<String> subjectList = xlsList.get(0);

        for (int i = 1; i < xlsList.size(); i++) {
            JSONObject jsonObject = new JSONObject(true);

            jsonObject.put("institude", xlsList.get(i).get(1));

            String num = xlsList.get(i).get(3);
            if (num.contains("-")) {
                num = num.split("-")[0];
            }
            jsonObject.put("rank", ScaleUtil.scale(2, Double.parseDouble(num)));
//                System.out.println(jsonObject.toString());

            result.add(JSONObject.parseObject(jsonObject.toString(), clazz));
        }

        return result;
    }

    public List<MajorRankVO> readMajorRank(String path) {
        List<List<String>> xlsList = readXls(path);
        List<MajorRankVO> result = new ArrayList<>();
        List<String> majors = xlsList.get(0);
        for (int i = 1; i < xlsList.size(); i++) {
            List<String> line = xlsList.get(i);
            for (int j = 3; j < majors.size() && j<line.size(); j++) {
                String rank = line.get(j);
                rank = rank.trim();
                if (StringUtils.isEmpty(rank))
                    continue;
                MajorRankVO majorRankVO = new MajorRankVO();
                majorRankVO.setInstitude(line.get(1));
                majorRankVO.setMajor(majors.get(j));

                if (rank.contains("-")) {
                    rank = rank.split("-")[0];
                }
                majorRankVO.setRank(ScaleUtil.scale(2, Double.parseDouble(rank)));
                result.add(majorRankVO);
            }
        }
        return result;
    }

    /**
     * 将Excel文件读取为二维字符串数组
     *
     * @param path 文件路径
     * @return
     * @throws Exception
     */
    public List<List<String>> readXls(String path) {
        Workbook book = null;
        book = getExcelWorkbook(path);
        Sheet sheet = getSheetByNum(book, 0);

        int lastRowNum = sheet.getLastRowNum();

        List<List<String>> result = new ArrayList<List<String>>();

        //遍历每一行
        for (int i = 0; i <= lastRowNum; i++) {
            Row row = null;
            row = sheet.getRow(i);
            List<String> rowList = new ArrayList<String>();
            if (row != null) {
//                System.out.println("reading line is " + i);
                int lastCellNum = row.getLastCellNum();
//                System.out.println("lastCellNum is " + lastCellNum );
                Cell cell = null;
                //遍历每一列
                for (int j = 0; j <= lastCellNum; j++) {
                    cell = row.getCell(j);

                    String cellValue = getStringVal(cell);
                    rowList.add(cellValue);
//
                }
            }
            result.add(rowList);
        }
        return result;
    }

    /**
     * 获取Sheet
     *
     * @param book
     * @param number
     * @return
     */
    private Sheet getSheetByNum(Workbook book, int number) {
        Sheet sheet = null;
        try {
            sheet = book.getSheetAt(number);
//          if(sheet == null){
//              sheet = book.createSheet("Sheet"+number);
//          }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return sheet;
    }

    /**
     * 获取Workbook
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    private Workbook getExcelWorkbook(String filePath) {
        Workbook book = null;
        File file = null;
        FileInputStream fis = null;

        try {
            file = new File(filePath);
            if (!file.exists()) {
                throw new RuntimeException("文件不存在");
            } else {
                fis = new FileInputStream(file);
                book = WorkbookFactory.create(fis);
            }
            if (fis != null) {
                fis.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return book;
    }

    /**
     * 将单元格元素内容转换为String型
     *
     * @param cell
     * @return
     */
    public String getStringVal(Cell cell) {
        if (cell == null)
            return "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
            case Cell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            case Cell.CELL_TYPE_NUMERIC:
                short format = cell.getCellStyle().getDataFormat();
                SimpleDateFormat sdf = null;
                if (format == 14 || format == 31 || format == 57 || format == 58
                        || (176<=format && format<=178) || (182<=format && format<=196)
                        || (210<=format && format<=213) || (208==format ) ) { // 日期
                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue());
                    return sdf.format(date);
                }
                cell.setCellType(Cell.CELL_TYPE_STRING);
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            default:
                return "";
        }
    }

    public static void main(String[] args) throws Exception {
//        List<Question> jsonList = new HandleExcelUtil().readXlsToJson("2016.xlsx",Question.class);
//        System.out.println(jsonList.size()+" "+jsonList.get(0).getDescription());
    }
}
