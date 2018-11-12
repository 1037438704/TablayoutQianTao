package zdl.tianxunda.com.tablayoutqiantao.bean;

import java.util.List;

/**
 * Created by dell-pc on 2018/10/25.
 */

public class MarketAllTickersBean {

    /**
     * code : 1
     * message : 请求成功
     * data : {"list":[{"ticker_id":"3","market":"bitmex","base_symbol":"ADA","transaction_symbol":"XBT","last_price":"0.00001204","base_volume":"0.00652471","bid":"0.00001204","ask":"0.00001205","change_daily":"0.0042","ticker":"ADA/XBT","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc14f426c1a3.png"},{"ticker_id":"5","market":"bitmex","base_symbol":"XRP","transaction_symbol":"XBT","last_price":"0.00007175","base_volume":"0.145701","bid":"0.00007174","ask":"0.00007175","change_daily":"0.0049","ticker":"XRP/XBT","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc156021b56c.png"},{"ticker_id":"7","market":"bitmex","base_symbol":"EOS","transaction_symbol":"XBT","last_price":"0.000852","base_volume":"0.475671","bid":"0.0008519","ask":"0.000852","change_daily":"0.0136","ticker":"EOS/XBT","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc150f452836.png"},{"ticker_id":"2","market":"bitmex","base_symbol":"LTC","transaction_symbol":"XBT","last_price":"0.00829","base_volume":"3.95262","bid":"0.00829","ask":"0.0083","change_daily":"-0.0012","ticker":"LTC/XBT","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc1533c62748.png"},{"ticker_id":"4","market":"bitmex","base_symbol":"BCH","transaction_symbol":"XBT","last_price":"0.0709","base_volume":"93.4279","bid":"0.0708","ask":"0.0709","change_daily":"0.0201","ticker":"BCH/XBT","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc14e00701d4.png"},{"ticker_id":"6","market":"bitmex","base_symbol":"ETH","transaction_symbol":"XBT","last_price":"203.8","base_volume":"3574910","bid":"203.8","ask":"203.85","change_daily":"0.002","ticker":"ETH/XBT","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc1515d5c188.png"},{"ticker_id":"1","market":"bitmex","base_symbol":"XBT","transaction_symbol":"USD","last_price":"6432","base_volume":"415164000","bid":"6431.5","ask":"6432","change_daily":"0.004","ticker":"XBT/USD","icon":"http://app.coinwind.io/Uploads/Symbols/default.png"}],"transaction_symbol_list":[{"transaction_symbol":"全部"},{"transaction_symbol":"USD"},{"transaction_symbol":"XBT"},{"transaction_symbol":"XBT"},{"transaction_symbol":"XBT"},{"transaction_symbol":"XBT"},{"transaction_symbol":"XBT"},{"transaction_symbol":"XBT"}]}
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
        private List<ListBean> list;
        private List<TransactionSymbolListBean> transaction_symbol_list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<TransactionSymbolListBean> getTransaction_symbol_list() {
            return transaction_symbol_list;
        }

        public void setTransaction_symbol_list(List<TransactionSymbolListBean> transaction_symbol_list) {
            this.transaction_symbol_list = transaction_symbol_list;
        }

        public static class ListBean {
            /**
             * ticker_id : 3
             * market : bitmex
             * base_symbol : ADA
             * transaction_symbol : XBT
             * last_price : 0.00001204
             * base_volume : 0.00652471
             * bid : 0.00001204
             * ask : 0.00001205
             * change_daily : 0.0042
             * ticker : ADA/XBT
             * icon : http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc14f426c1a3.png
             */

            private String ticker_id;
            private String market;
            private String base_symbol;
            private String transaction_symbol;
            private String last_price;
            private String base_volume;
            private String bid;
            private String ask;
            private String change_daily;
            private String ticker;
            private String icon;

            public String getTicker_id() {
                return ticker_id;
            }

            public void setTicker_id(String ticker_id) {
                this.ticker_id = ticker_id;
            }

            public String getMarket() {
                return market;
            }

            public void setMarket(String market) {
                this.market = market;
            }

            public String getBase_symbol() {
                return base_symbol;
            }

            public void setBase_symbol(String base_symbol) {
                this.base_symbol = base_symbol;
            }

            public String getTransaction_symbol() {
                return transaction_symbol;
            }

            public void setTransaction_symbol(String transaction_symbol) {
                this.transaction_symbol = transaction_symbol;
            }

            public String getLast_price() {
                return last_price;
            }

            public void setLast_price(String last_price) {
                this.last_price = last_price;
            }

            public String getBase_volume() {
                return base_volume;
            }

            public void setBase_volume(String base_volume) {
                this.base_volume = base_volume;
            }

            public String getBid() {
                return bid;
            }

            public void setBid(String bid) {
                this.bid = bid;
            }

            public String getAsk() {
                return ask;
            }

            public void setAsk(String ask) {
                this.ask = ask;
            }

            public String getChange_daily() {
                return change_daily;
            }

            public void setChange_daily(String change_daily) {
                this.change_daily = change_daily;
            }

            public String getTicker() {
                return ticker;
            }

            public void setTicker(String ticker) {
                this.ticker = ticker;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

        public static class TransactionSymbolListBean {
            /**
             * transaction_symbol : 全部
             */

            private String transaction_symbol;
            public boolean aBoolean;

            public String getTransaction_symbol() {
                return transaction_symbol;
            }

            public void setTransaction_symbol(String transaction_symbol) {
                this.transaction_symbol = transaction_symbol;
            }
        }
    }
}
