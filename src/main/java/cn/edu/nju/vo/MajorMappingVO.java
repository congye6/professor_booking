package cn.edu.nju.vo;

public class MajorMappingVO {

    /**
     * 原来的专业名
     */
    private String oldMajor;

    /**
     * 映射后的专业名
     */
    private String newMajor;

    /**
     * 用来排名的专业分类
     */
    private String majorType;

    public String getOldMajor() {
        return oldMajor;
    }

    public void setOldMajor(String oldMajor) {
        this.oldMajor = oldMajor;
    }

    public String getNewMajor() {
        return newMajor;
    }

    public void setNewMajor(String newMajor) {
        this.newMajor = newMajor;
    }

    public String getMajorType() {
        return majorType;
    }

    public void setMajorType(String majorType) {
        this.majorType = majorType;
    }
}
