

import lombok.Getter;

@Getter
public enum IsNotEnum {

    /**
     * 数据被逻辑删除
     */
    DELETE(0, "删除"),
    /**
     * 数据正常
     */
    NORMAL(1, "有效");

    public int value;
    public String desc;

    IsNotEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static String getDescByValue(int value) {
        for (IsNotEnum item : IsNotEnum.values()) {
            if (item.getValue() == value) {
                return item.getDesc();
            }
        }
        return "";
    }
}
