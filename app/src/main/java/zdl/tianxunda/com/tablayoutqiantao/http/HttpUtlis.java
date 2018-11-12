package zdl.tianxunda.com.tablayoutqiantao.http;

/**
 * Created by dell-pc on 2018/10/11.
 */

public class HttpUtlis {
    /**
     * 主URL
     */
    public static String http = "http://app.coinwind.io/index.php/Api/";

    public static String TOUODATE = "Upgrade/upgrade";//更新
    /**
     * 登录模块
     */
    public static String GetANARTICLE = "Article/getArticle";//获取文章
    public static String SENDTEXTMESSAGES = "Sms/sendVerify";//发送短信验证码
    public static String VERIFYINGSMS = "Sms/checkVerify";//验证短信验证码
    public static String LOGINPSD = "Member/login";//账号密码登录1
    public static String RETRIEVETHEPASSWORD = "Member/resetPassword";//找回密码1
    public static String QUICKLOGON = "Member/smsLogin";//快速登录1

    /**
     * 我的模块
     */
    public static String BASICINFORMATION = "Member/memberBaseData";//基本资料
    public static String PERSONALDATA = "Member/memberCenter";//个人资料
    public static String CHANGEPSD = "Member/modPassword";//修改密码
    public static String HEADIMAGE = http + "Member/modHeadPic";//修改头像
    public static String NICKNAME = "Member/modNickname";//修改昵称
    public static String BINDINGPHONE = "Member/modAccount";//修改绑定手机号
    public static String PROMOTIONSHARING = "Member/getInviteMsg";//推广分享给好友
    public static String SETUPTHERISE = "Member/setGain";//设置涨幅
    public static String UNITSWITCHING = "Member/setSalesUnit";//单位切换
    public static String FEEDBACK = "Feedback/addFeedback";//意见反馈
    public static String CONTACTUS = "Member/contactUs";//联系我们
    public static String SWEETBOX = "Member/checkPage";//我的-糖果盒子
    public static String SIGNIN = "Member/check";//签到
    public static String COLLECT_THE_DETAILS = "Member/checkReceiveLog";//我的-糖果盒子-领取明细


    /**
     * 快讯列表
     */
    public static String MESSAGELIST = "Information/newsletterList";//快讯列表
    public static String GOODANDBADPROFITS = "Information/setInformationOption";//设置利好和利空
    public static String DETAILSOFTHENEWS = "Information/newsletterInfo";//快讯详情      2
    public static String INFORMATIONLIST = "Information/informationList";//资讯列表
    public static String INFORMATIONDETAILS = "Information/informationInfo";//资讯详情
    public static String SETCONCERNS = "Information/setFollow";//设置关注
    public static String BULLETINLIST = "Information/announcementList";//公告列表
    public static String DETAILSOFTHEANNOUNCEMENT = "Information/announcementInfo";//公告详情

    /**
     * 自选首页
     */
    public static String HOMEPAGE = "Optional/optionalIndex";//自选首页
    public static String INTELLIGENTRECOMMENDATION = "Optional/intelligentRecommend";//智能推荐
    public static String TOPSETTIONG = "Optional/setTop";//置顶设置
    public static String DELETIONGCURRENCY = "Optional/deleteMemberSymbol";//删除已添加币种
    public static String ADDCURRENCY = "Optional/addMemberSymbol";//添加币种
    public static String SEARCHINTERFACE = "Optional/searchPage";//搜索界面
    public static String SEARCH = "Optional/search";//搜索
    public static String SELECTIONINFORMATION = "Optional/informationList";//自选-资讯列表
    public static String SELECTIONNEWSFLASH = "Optional/newsletterList";//自选-快讯列表
    public static String SELECTIONNOTICE = "Optional/announcementList";//自选公告列表

    /**
     * 行情界面
     */
    public static String MARKETVALUE = "Quotes/marketCurrency";//市值-币种
    public static String RISE_AND_FALL = "Quotes/currency24H";//币种-24H涨跌幅
    public static String ALL_MARKETS = "Quotes/marketAllTickers";//交易所-全部市场
    public static String BULLETIN_LIST = "Quotes/marketAnnouncementList";//交易所-公告列表
    public static String EXCHANGE_DETAILS = "Quotes/marketInfo";//交易所详情
    public static String MONEY_FLOW = "Quotes/capitalFlows";//资金流向
    public static String TURNOVER_RATE = "Quotes/changeHands";//换手率
    public static String HIGHEST_HISTORY = "Quotes/historyHighPrice";//历史最高价
    public static String BLOCK = "Quotes/section";//版块
    public static String CURRENCY_LIST = "Quotes/sectionSymbolList";//版块币种列表
    public static String EXCHANGE_HOME_PAGE = "Quotes/marketIndex";//交易所首页
    public static String SETTING_UP_A_REMINDER = "Quotes/setRemind";//设置提醒



    /**
     * 币资产
     * */
    public static String SEARCH_THE_CURRENCY = "Assets/searchSymbol";//搜索币种
    public static String CHOOSE_THE_MARKET = "Assets/searchMarket";//选择市场
    public static String ADD_ASSETS = "Assets/addAssets";//添加资产
    public static String CURRENCY_ASSETS_HOME_PAGE = "Assets/assetsIndex";//币资产首页
    public static String ASSET_DETAILS = "Assets/assetsInfo";//资产详情
    public static String EDIT_THE_ASSETS = "Assets/modAssets";//编辑资产

    /**
     * 详情数据
     * */
    public static String SYMINFO = "Symbols/symInfo";//行情页-顶部数据
    public static String SYMINFOPRICE = "Symbols/symInfoPrice";//行情页--报价
    public static String SYMINFOSKETCH = "Symbols/symInfoSketch";//行情页--简况

}
