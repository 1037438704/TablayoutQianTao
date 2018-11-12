package zdl.tianxunda.com.tablayoutqiantao.bean;

import java.util.List;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2018/10/6 16:00
 * 功能描述： 搜索界面
 * 联系方式：1037438704@qq.com
 *
 * @author dell-pc
 */

public class SearchXQBean {
    /**
     * code : 1
     * message : 请求成功
     * data : {"symbol_list":[{"symbol_id":"1","name":"bitcoin","symbol":"BTC","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc14df3da715.png","is_choose":"1"},{"symbol_id":"4","name":"bitcoin-cash","symbol":"BCH","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc14e00701d4.png","is_choose":"0"},{"symbol_id":"6","name":"litecoin","symbol":"LTC","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc1533c62748.png","is_choose":"0"},{"symbol_id":"9","name":"tron","symbol":"TRX","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc157c7b4af0.png","is_choose":"0"},{"symbol_id":"10","name":"cardano","symbol":"ADA","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc14f426c1a3.png","is_choose":"0"},{"symbol_id":"14","name":"neo","symbol":"NEO","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc1545175a5e.png","is_choose":"0"},{"symbol_id":"15","name":"dogecoin","symbol":"DOGE","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc15074bb60a.png","is_choose":"0"},{"symbol_id":"16","name":"crowd-machine","symbol":"CMCT","icon":"http://app.coinwind.io/Uploads/Symbols/default.png","is_choose":"0"},{"symbol_id":"18","name":"ontology","symbol":"ONT","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc154c5d7fdc.png","is_choose":"0"},{"symbol_id":"19","name":"monero","symbol":"XMR","icon":"http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc15412a71f3.png","is_choose":"0"}],"markets_list":[{"markets_id":"1","name":"bitmex","display_name":"BitMEX","icon":"http://app.coinwind.io/Uploads/Markets/default.png"},{"markets_id":"2","name":"binance","display_name":"Binance","icon":"http://app.coinwind.io/Uploads/Markets/default.png"},{"markets_id":"3","name":"okex","display_name":"OKEX","icon":"http://app.coinwind.io/Uploads/Markets/default.png"},{"markets_id":"4","name":"huobipro","display_name":"Huobi Global","icon":"http://app.coinwind.io/Uploads/Markets/default.png"},{"markets_id":"5","name":"bitfinex","display_name":"Bitfinex","icon":"http://app.coinwind.io/Uploads/Markets/default.png"},{"markets_id":"6","name":"bithumb","display_name":"Bithumb","icon":"http://app.coinwind.io/Uploads/Markets/default.png"},{"markets_id":"7","name":"upbit","display_name":"UPbit","icon":"http://app.coinwind.io/Uploads/Markets/default.png"},{"markets_id":"8","name":"coinsbank","display_name":"Coinsbank","icon":"http://app.coinwind.io/Uploads/Markets/default.png"},{"markets_id":"9","name":"bitbank","display_name":"bitbank","icon":"http://app.coinwind.io/Uploads/Markets/default.png"},{"markets_id":"10","name":"kraken","display_name":"Kraken","icon":"http://app.coinwind.io/Uploads/Markets/default.png"}]}
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
        private List<SymbolListBean> symbol_list;
        private List<MarketsListBean> markets_list;

        public List<SymbolListBean> getSymbol_list() {
            return symbol_list;
        }

        public void setSymbol_list(List<SymbolListBean> symbol_list) {
            this.symbol_list = symbol_list;
        }

        public List<MarketsListBean> getMarkets_list() {
            return markets_list;
        }

        public void setMarkets_list(List<MarketsListBean> markets_list) {
            this.markets_list = markets_list;
        }

        public static class SymbolListBean {
            /**
             * symbol_id : 1
             * name : bitcoin
             * symbol : BTC
             * icon : http://app.coinwind.io/Uploads/Symbols/2018-10-13/5bc14df3da715.png
             * is_choose : 1
             */

            private String symbol_id;
            private String name;
            private String symbol;
            private String icon;
            private String is_choose;

            public String getSymbol_id() {
                return symbol_id;
            }

            public void setSymbol_id(String symbol_id) {
                this.symbol_id = symbol_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getIs_choose() {
                return is_choose;
            }

            public void setIs_choose(String is_choose) {
                this.is_choose = is_choose;
            }
        }

        public static class MarketsListBean {
            /**
             * markets_id : 1
             * name : bitmex
             * display_name : BitMEX
             * icon : http://app.coinwind.io/Uploads/Markets/default.png
             */

            private String markets_id;
            private String name;
            private String display_name;
            private String icon;

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

            public String getDisplay_name() {
                return display_name;
            }

            public void setDisplay_name(String display_name) {
                this.display_name = display_name;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
    }
}
