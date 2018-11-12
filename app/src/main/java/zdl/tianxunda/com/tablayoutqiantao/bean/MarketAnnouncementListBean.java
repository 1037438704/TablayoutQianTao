package zdl.tianxunda.com.tablayoutqiantao.bean;

import java.util.List;

/**
 * Created by dell-pc on 2018/10/25.
 */

public class MarketAnnouncementListBean {

    /**
     * code : 1
     * message : 请求成功
     * data : {"announcement_list":[{"information_id":"942","title":"ET提币开放时间CET提币开放时间公告！","content":"尊敬的用户：\r\n据韩国《中央日报》本周报道，韩国庆尚北道省透漏经 开始着手使用一种加密货币取代当地货币。\r\nCEO交易所\r\n2018.02.07","create_time":"1539226413"},{"information_id":"941","title":"提币开放时间CET提币开放时间公告！","content":"尊敬的用户：\r\n据韩国《中央日报》本周报道，韩国庆尚北道省透漏经 开始着手使用一种加密货币取代当地货币。\r\nCEO交易所","create_time":"1539226375"}],"announcement_type":[{"announcement_type_id":"1","type_name":"新币上线"},{"announcement_type_id":"2","type_name":"交易流通"},{"announcement_type_id":"3","type_name":"主网更新"},{"announcement_type_id":"4","type_name":"投票上币"},{"announcement_type_id":"5","type_name":"平台活动"},{"announcement_type_id":"6","type_name":"平台业务"},{"announcement_type_id":"7","type_name":"其他"}],"markets":[{"markets_id":"1","name":"bitmex"},{"markets_id":"2","name":"binance"}]}
     */

    private String code;
    private String message;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<AnnouncementListBean> announcement_list;
        private List<AnnouncementTypeBean> announcement_type;
        private List<MarketsBean> markets;

        public List<AnnouncementListBean> getAnnouncement_list() {
            return announcement_list;
        }

        public void setAnnouncement_list(List<AnnouncementListBean> announcement_list) {
            this.announcement_list = announcement_list;
        }

        public List<AnnouncementTypeBean> getAnnouncement_type() {
            return announcement_type;
        }

        public void setAnnouncement_type(List<AnnouncementTypeBean> announcement_type) {
            this.announcement_type = announcement_type;
        }

        public List<MarketsBean> getMarkets() {
            return markets;
        }

        public void setMarkets(List<MarketsBean> markets) {
            this.markets = markets;
        }

        public static class AnnouncementListBean {
            /**
             * information_id : 942
             * title : ET提币开放时间CET提币开放时间公告！
             * content : 尊敬的用户：
             据韩国《中央日报》本周报道，韩国庆尚北道省透漏经 开始着手使用一种加密货币取代当地货币。
             CEO交易所
             2018.02.07
             * create_time : 1539226413
             */

            private String information_id;
            private String title;
            private String content;
            private String create_time;

            public String getInformation_id() {
                return information_id;
            }

            public void setInformation_id(String information_id) {
                this.information_id = information_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }
        }

        public static class AnnouncementTypeBean {
            /**
             * announcement_type_id : 1
             * type_name : 新币上线
             */

            private String announcement_type_id;
            private String type_name;
            public boolean aBoolean;

            public String getAnnouncement_type_id() {
                return announcement_type_id;
            }

            public void setAnnouncement_type_id(String announcement_type_id) {
                this.announcement_type_id = announcement_type_id;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }
        }

        public static class MarketsBean {
            /**
             * markets_id : 1
             * name : bitmex
             */

            private String markets_id;
            private String name;

            public String getMarkets_id() {
                return markets_id;
            }

            public void setMarkets_id(String markets_id) {
                this.markets_id = markets_id;
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
