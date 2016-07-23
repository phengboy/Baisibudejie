package bean;

import java.util.List;

/**
 * Created by pheng on 2016/5/10.
 */
public class MineBean {

    /**
     * id : 28
     * name : 审贴
     * icon : http://img.spriteapp.cn/ugc/2015/05/20/150532_5078.png
     * url : mod://BDJ_To_Check
     * android :
     * iphone :
     * ipad :
     */

    private List<SquareListBean> square_list;

    public List<SquareListBean> getSquare_list() {
        return square_list;
    }

    public void setSquare_list(List<SquareListBean> square_list) {
        this.square_list = square_list;
    }

    public static class SquareListBean {
        private String id;
        private String name;
        private String icon;
        private String url;
        private String android;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAndroid() {
            return android;
        }

        public void setAndroid(String android) {
            this.android = android;
        }
    }
}
