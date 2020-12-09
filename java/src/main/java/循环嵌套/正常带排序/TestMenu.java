package 循环嵌套.正常带排序;

import java.util.ArrayList;
import java.util.List;

public class TestMenu {

    public static void main(String[] args) {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu(1L,"公司1",null));
        menus.add(new Menu(2L,"公司2",1L));
        menus.add(new Menu(3L,"公司3",2L));
        menus.add(new Menu(4L,"公司4",2L));
        menus.add(new Menu(5L,"公司5",1L));
        menus.add(new Menu(6L,"公司6",null));
        menus.add(new Menu(7L,"公司7",4L));
        List<Menu> treeMenus = Menu.createTreeMenus(menus);

    }
}
