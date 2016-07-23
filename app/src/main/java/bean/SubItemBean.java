package bean;

import java.util.List;

/**
 * Created by pheng on 2016/5/12.
 */
public class SubItemBean {

    /**
     * count : 1031
     * np : 7.92408453E8
     */

    private InfoBean info;
    /**
     * comment : 24
     * tags : [{"id":1,"name":"搞笑"},{"id":61,"name":"恶搞"},{"id":62,"name":"内涵"},{"id":1930,"name":"体育"}]
     * bookmark : 13
     * text : 赛场上什么都可能发生，图片较长✔✔✔
     * image : {"medium":[],"big":["http://wimg.spriteapp.cn/ugc/2016/04/22/5719da70a1891_1.jpg","http://dimg.spriteapp.cn/ugc/2016/04/22/5719da70a1891_1.jpg"],"download_url":["http://wimg.spriteapp.cn/ugc/2016/04/22/5719da70a1891_d.jpg","http://dimg.spriteapp.cn/ugc/2016/04/22/5719da70a1891_d.jpg","http://wimg.spriteapp.cn/ugc/2016/04/22/5719da70a1891.jpg","http://dimg.spriteapp.cn/ugc/2016/04/22/5719da70a1891.jpg"],"height":15340,"width":990,"small":[]}
     * up : 235
     * share_url : http://a.f.winapp111.cn/share/18183336.html?wx.qq.com
     * down : 41
     * forward : 7
     * u : {"header":["http://wimg.spriteapp.cn/profile/large/2016/04/19/5716132004d62_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/04/19/5716132004d62_mini.jpg"],"is_v":false,"uid":"3114990","is_vip":false,"name":"不是我不想說"}
     * passtime : 2016-04-22 20:16:45
     * type : image
     * id : 18183336
     */

    private List<ListBean> list;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class InfoBean {
        private int count;
        private double np;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public double getNp() {
            return np;
        }

        public void setNp(double np) {
            this.np = np;
        }
    }

    public static class ListBean {
        private String comment;
        private String bookmark;
        private String text;
        /**
         * medium : []
         * big : ["http://wimg.spriteapp.cn/ugc/2016/04/22/5719da70a1891_1.jpg","http://dimg.spriteapp.cn/ugc/2016/04/22/5719da70a1891_1.jpg"]
         * download_url : ["http://wimg.spriteapp.cn/ugc/2016/04/22/5719da70a1891_d.jpg","http://dimg.spriteapp.cn/ugc/2016/04/22/5719da70a1891_d.jpg","http://wimg.spriteapp.cn/ugc/2016/04/22/5719da70a1891.jpg","http://dimg.spriteapp.cn/ugc/2016/04/22/5719da70a1891.jpg"]
         * height : 15340
         * width : 990
         * small : []
         */

        private ImageBean image;
        private String up;
        private String share_url;
        private int down;
        private String forward;
        /**
         * header : ["http://wimg.spriteapp.cn/profile/large/2016/04/19/5716132004d62_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/04/19/5716132004d62_mini.jpg"]
         * is_v : false
         * uid : 3114990
         * is_vip : false
         * name : 不是我不想說
         */

        private UBean u;
        private String passtime;

        /**
         * id : 1
         * name : 搞笑
         */
        private GifBean gif;

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

        public GifBean getGif() {
            return gif;
        }

        public void setGif(GifBean gif) {
            this.gif = gif;
        }

        public ImageBean getImage() {
            return image;
        }

        public void setImage(ImageBean image) {
            this.image = image;
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
        public static class GifBean {
            private List<String> images;
            private int width;
            private List<String> gif_thumbnail;
            private List<String> download_url;
            private int height;


            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
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

            public List<String> getGif_thumbnail() {
                return gif_thumbnail;
            }

            public void setGif_thumbnail(List<String> gif_thumbnail) {
                this.gif_thumbnail = gif_thumbnail;
            }

            public List<String> getDownload_url() {
                return download_url;
            }

            public void setDownload_url(List<String> download_url) {
                this.download_url = download_url;
            }
        }

        public static class ImageBean {
            private int height;
            private int width;
            private List<?> medium;
            private List<String> big;
            private List<String> download_url;
            private List<?> small;

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

            public List<?> getMedium() {
                return medium;
            }

            public void setMedium(List<?> medium) {
                this.medium = medium;
            }

            public List<String> getBig() {
                return big;
            }

            public void setBig(List<String> big) {
                this.big = big;
            }

            public List<String> getDownload_url() {
                return download_url;
            }

            public void setDownload_url(List<String> download_url) {
                this.download_url = download_url;
            }

            public List<?> getSmall() {
                return small;
            }

            public void setSmall(List<?> small) {
                this.small = small;
            }
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
