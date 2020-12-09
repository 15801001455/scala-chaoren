package 循环嵌套.简单模式不合适;

import java.util.ArrayList;
import java.util.List;

public class ToolUtil {
    private List<OrgInfo> list;

    private List<OrgInfo> resultList = new ArrayList<>();

    public void setList(List<OrgInfo> list){
        this.list = list;
    }

    public List<OrgInfo> getList(){
        make();
        return resultList;
    }

    private void make(){
        for(OrgInfo info : list){
            if(info.getSupid() == null){
                resultList.add(info);
                transferList(info.getId());
            }
        }
    }

    private void transferList(Long id){
        for(OrgInfo p : list){
            if(p.getSupid() != null && p.getSupid() == id){
                resultList.add(p);
                transferList(p.getId());
            }
        }
    }

    public static void main(String[] args) {
        List<OrgInfo> list = new ArrayList<>();
        list.add(new OrgInfo(1L,null,"北京",100L,"北京分公司1"));
        list.add(new OrgInfo(2L,null,"北京",101L,"北京分公司2"));
        list.add(new OrgInfo(3L,1L,"上海",102L,"上海分公司1"));
        list.add(new OrgInfo(4L,1L,"南京",103L,"南京分公司1"));
        ToolUtil toolUtil = new ToolUtil();
        toolUtil.setList(list);
        System.out.println(toolUtil.getList());
    }
}
