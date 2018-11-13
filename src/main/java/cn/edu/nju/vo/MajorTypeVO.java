package cn.edu.nju.vo;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/13
 */
public class MajorTypeVO {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MajorTypeVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
