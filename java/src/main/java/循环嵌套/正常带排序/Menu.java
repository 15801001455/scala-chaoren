package 循环嵌套.正常带排序;

import lombok.Data;

import java.io.Serializable;
import java.util.*;

@Data
public class Menu implements Serializable {
    /**
     * 菜单id
     */
    private Long id;

    public Menu() {}

    public Menu(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 子菜单
     */
    private List<Menu> children = new ArrayList<Menu>();

    /**
     * 菜单顺序
     */
    private Integer orderby;

    /**
     * 菜单状态
     */
    private String state;

    public void sortChildren(){
        Collections.sort(children, new Comparator<Menu>() {
            @Override
            public int compare(Menu o1, Menu o2) {
                int result = 0;
                Integer orderby1 = o1.getOrderby();
                Integer orderby2 = o2.getOrderby();
                Long id1 = o1.getId();
                Long id2 = o2.getId();
                if(null != orderby1 && null != orderby2){
                    result = (orderby1 < orderby2 ? -1 : (orderby1 == orderby2 ? 0 : 1));
                }else{
                    result = (id1 < id2 ? -1 : (id1 == id2 ? 0 : 1));
                }
                return result;
            }
        });
        //对每个节点的下一层节点进行排序
        children.forEach(item -> item.sortChildren());
      /*  for(Iterator<Menu> it = children.iterator();it.hasNext();){
            it.next().sortChildren();
        }*/
    }

    public static List<Menu> createTreeMenus(List<Menu> menus){
        List<Menu> treeMenus = null;
        if(null != menus && !menus.isEmpty()){
            Menu root = new Menu();
            root.setName("根目录");
            // 组装map数据
            Map<Long,Menu> dataMap = new HashMap<>();
            for(Menu menu : menus){
                dataMap.put(menu.getId(),menu);
            }
            //组装树形结构
            Set<Map.Entry<Long, Menu>> entrySet = dataMap.entrySet();
            for(Map.Entry<Long,Menu> entry : entrySet){
                Menu menu = entry.getValue();
                if(null == menu.getParentId() || 0L == menu.getParentId()) {
                    root.getChildren().add(menu);
                }else{
                    dataMap.get(menu.getParentId()).getChildren().add(menu);
                }
            }
            root.sortChildren();
            treeMenus = root.getChildren();
        }
        return treeMenus;
    }
}
