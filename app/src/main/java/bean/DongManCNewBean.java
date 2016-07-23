package bean;

import java.util.List;

/**
 * Created by pheng on 2016/5/12.
 */
public class DongManCNewBean {

    /**
     * comment : 0
     * tags : [{"id":9826,"name":"召集动漫迷"},{"id":445,"name":"动漫"},{"id":55,"name":"微视频"},{"id":1,"name":"搞笑"}]
     * bookmark : 0
     * text : 忍者勇士第2集...(團隊正式成立)
     * up : 47
     * share_url : http://c.f.winapp111.mobi/share/16885016.html?wx.qq.com
     * down : 21
     * forward : 0
     * u : {"header":["http://wimg.spriteapp.cn/profile/large/2016/05/08/572e1ca64f19d_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/05/08/572e1ca64f19d_mini.jpg"],"is_v":true,"uid":"14721536","is_vip":false,"name":"动漫达人Mr_十冂丫二"}
     * passtime : 2016-01-15 11:56:37
     * video : {"playfcount":52,"height":266,"width":480,"video":["http://dvideo.spriteapp.cn/video/2016/0115/569865e972fd4_wpd.mp4","http://wvideo.spriteapp.cn/video/2016/0115/569865e972fd4_wpd.mp4","http://bvideo.spriteapp.cn/video/2016/0115/569865e972fd4_wpd.mp4"],"duration":636,"playcount":187,"thumbnail":["http://dimg.spriteapp.cn/picture/2016/0115/569865e972fd4_wpd.jpg","http://wimg.spriteapp.cn/picture/2016/0115/569865e972fd4_wpd.jpg"],"download":["http://dvideo.spriteapp.cn/video/2016/0115/569865e972fd4_wpc.mp4","http://wvideo.spriteapp.cn/video/2016/0115/569865e972fd4_wpc.mp4","http://bvideo.spriteapp.cn/video/2016/0115/569865e972fd4_wpc.mp4"]}
     * type : video
     * id : 16885016
     */

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String comment;
        private String bookmark;
        private String text;
        private String up;
        private String share_url;
        private int down;
        private String forward;
        /**
         * header : ["http://wimg.spriteapp.cn/profile/large/2016/05/08/572e1ca64f19d_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/05/08/572e1ca64f19d_mini.jpg"]
         * is_v : true
         * uid : 14721536
         * is_vip : false
         * name : 动漫达人Mr_十冂丫二
         */

        private UBean u;
        private String passtime;
        /**
         * playfcount : 52
         * height : 266
         * width : 480
         * video : ["http://dvideo.spriteapp.cn/video/2016/0115/569865e972fd4_wpd.mp4","http://wvideo.spriteapp.cn/video/2016/0115/569865e972fd4_wpd.mp4","http://bvideo.spriteapp.cn/video/2016/0115/569865e972fd4_wpd.mp4"]
         * duration : 636
         * playcount : 187
         * thumbnail : ["http://dimg.spriteapp.cn/picture/2016/0115/569865e972fd4_wpd.jpg","http://wimg.spriteapp.cn/picture/2016/0115/569865e972fd4_wpd.jpg"]
         * download : ["http://dvideo.spriteapp.cn/video/2016/0115/569865e972fd4_wpc.mp4","http://wvideo.spriteapp.cn/video/2016/0115/569865e972fd4_wpc.mp4","http://bvideo.spriteapp.cn/video/2016/0115/569865e972fd4_wpc.mp4"]
         */

        private VideoBean video;
        private String type;
        private String id;
        /**
         * id : 9826
         * name : 召集动漫迷
         */

        private List<TagsBean> tags;

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getBookmark() {
            return bookmark;
        }

        public void setBookmark(String bookmark) {
            this.bookmark = bookmark;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUp() {
            return up;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getDown() {
            return down;
        }

        public void setDown(int down) {
            this.down = down;
        }

        public String getForward() {
            return forward;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public UBean getU() {
            return u;
        }

        public void setU(UBean u) {
            this.u = u;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }

        public VideoBean getVideo() {
            return video;
        }

        public void setVideo(VideoBean video) {
            this.video = video;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class UBean {
            private boolean is_v;
            private String uid;
            private boolean is_vip;
            private String name;
            private List<String> header;

            public boolean isIs_v() {
                return is_v;
            }

            public void setIs_v(boolean is_v) {
                this.is_v = is_v;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public boolean isIs_vip() {
                return is_vip;
            }

            public void setIs_vip(boolean is_vip) {
                this.is_vip = is_vip;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getHeader() {
                return header;
            }

            public void setHeader(List<String> header) {
                this.header = header;
            }
        }

        public static class VideoBean {
            private int playfcount;
            private int height;
            private int width;
            private int duration;
            private int playcount;
            private List<String> video;
            private List<String> thumbnail;
            private List<String> download;

            public int getPlayfcount() {
                return playfcount;
            }

            public void setPlayfcount(int playfcount) {
                this.playfcount = playfcount;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getPlaycount() {
                return playcount;
            }

            public void setPlaycount(int playcount) {
                this.playcount = playcount;
            }

            public List<String> getVideo() {
                return video;
            }

            public void setVideo(List<String> video) {
                this.video = video;
            }

            public List<String> getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(List<String> thumbnail) {
                this.thumbnail = thumbnail;
            }

            public List<String> getDownload() {
                return download;
            }

            public void setDownload(List<String> download) {
                this.download = download;
            }
        }

        public static class TagsBean {
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
        }
    }
}
