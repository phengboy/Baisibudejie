package bean;

import java.util.List;

/**
 * Created by pheng on 2016/5/10.
 */
public class SubBean {

    /**
     * theme_name : 召集动漫迷
     * image_detail :
     * post_num : 284
     * image_list :
     * is_sub : 0
     * sub_number : 14766
     * theme_id : 9826
     */

    private List<RecTagsBean> rec_tags;

    public List<RecTagsBean> getRec_tags() {
        return rec_tags;
    }

    public void setRec_tags(List<RecTagsBean> rec_tags) {
        this.rec_tags = rec_tags;
    }

    public static class RecTagsBean {
        private String theme_name;
        private String image_detail;
        private int post_num;
        private String image_list;
        private int is_sub;
        private int sub_number;
        private int theme_id;

        public String getTheme_name() {
            return theme_name;
        }

        public void setTheme_name(String theme_name) {
            this.theme_name = theme_name;
        }

        public String getImage_detail() {
            return image_detail;
        }

        public void setImage_detail(String image_detail) {
            this.image_detail = image_detail;
        }

        public int getPost_num() {
            return post_num;
        }

        public void setPost_num(int post_num) {
            this.post_num = post_num;
        }

        public String getImage_list() {
            return image_list;
        }

        public void setImage_list(String image_list) {
            this.image_list = image_list;
        }

        public int getIs_sub() {
            return is_sub;
        }

        public void setIs_sub(int is_sub) {
            this.is_sub = is_sub;
        }

        public int getSub_number() {
            return sub_number;
        }

        public void setSub_number(int sub_number) {
            this.sub_number = sub_number;
        }

        public int getTheme_id() {
            return theme_id;
        }

        public void setTheme_id(int theme_id) {
            this.theme_id = theme_id;
        }
    }
}
