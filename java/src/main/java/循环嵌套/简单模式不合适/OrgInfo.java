package 循环嵌套.简单模式不合适;

import lombok.Data;

@Data
public class OrgInfo {
    private Long id;
    private Long supid;//父节点id
    private String cityName;
    private Long companyId;
    private String companyName;

    public OrgInfo() {
    }

    public OrgInfo(Long id, Long supid, String cityName, Long companyId, String companyName) {
        this.id = id;
        this.supid = supid;
        this.cityName = cityName;
        this.companyId = companyId;
        this.companyName = companyName;
    }
}
