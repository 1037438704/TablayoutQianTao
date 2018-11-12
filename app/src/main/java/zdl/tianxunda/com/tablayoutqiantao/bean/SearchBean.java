package zdl.tianxunda.com.tablayoutqiantao.bean;

import java.util.List;

/**
 * Created by dell-pc on 2018/10/17.
 */

public class SearchBean {

    /**
     * code : 1
     * message : 请求成功
     * data : {"symbol_list":[{"symbol_id":"1","name":"bitcoin","symbol":"BTC"},{"symbol_id":"3","name":"ethereum","symbol":"ETH"},{"symbol_id":"4434","name":"akroma","symbol":"AKA"},{"symbol_id":"4437","name":"rocket-token","symbol":"ROCK"},{"symbol_id":"4440","name":"ryo","symbol":"RYO"}],"markets_list":[{"markets_id":"256","display_name":"nanex"},{"markets_id":"259","display_name":"foxbit"},{"markets_id":"260","display_name":"coinsecure"},{"markets_id":"264","display_name":"coinoah"},{"markets_id":"270","display_name":"mr-exchange"}]}
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
             */

            private String symbol_id;
            private String name;
            private String symbol;

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
        }

        public static class MarketsListBean {
            /**
             * markets_id : 256
             * display_name : nanex
             */

            private String markets_id;
            private String display_name;

            public String getMarkets_id() {
                return markets_id;
            }

            public void setMarkets_id(String markets_id) {
                this.markets_id = markets_id;
            }

            public String getDisplay_name() {
                return display_name;
            }

            public void setDisplay_name(String display_name) {
                this.display_name = display_name;
            }
        }
    }
}
