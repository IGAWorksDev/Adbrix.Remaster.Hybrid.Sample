package com.igaworks.adbrixrmhybridsample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.igaworks.v2.core.AdBrixRm;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private final String LOG_TAG = "ABXRM_HYBRID";
    private final String WEB_URL = "http://tech.ad-brix.com/adbrix_hybrid_sample_web/index.html";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdbrixRmInit();

        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new AdbrixRmHybridInterface(), "adbrix");
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl(WEB_URL);

    }

public class AdbrixRmHybridInterface {

    public AdbrixRmHybridInterface(){ }

    @JavascriptInterface
    public void purchase(String orderId, String productId, String productName, double price, int quantity, String currencyCode, String category){

        try {

            Log.d(LOG_TAG, "GET PURCHASE EVENT DATA FROM WEB WITH BELOW DATAS  ::: " +
                    "  \n  orderId :: " + orderId
                    + "\n  productId :: " + productId
                    + "\n  productName :: " + productName
                    + "\n  price :: " + price
                    + "\n  quantity :: " + quantity
                    + "\n  discount :: n/a"
                    + "\n  currencyCode :: " + currencyCode
                    + "\n  category :: " + category);

            /**
             * Create Product Model List For Purchased Products Details
             * */
            ArrayList productModelArrayList = new ArrayList<>();

            /**
             * Create Product Model With Product Details
             * */
            AdBrixRm.CommerceProductModel productModel =
                    new AdBrixRm.CommerceProductModel().setProductID(productId)
                            .setProductName(productName)
                            .setCategory(new AdBrixRm.CommerceCategoriesModel().setCategory(category))
                            .setPrice(price)
                            .setQuantity(quantity)
                            .setCurrency(AdBrixRm.Currency.getCurrencyByCurrencyCode(currencyCode));

            /**
             * Put The Purchased Product Details Into Product Model List
             * */
            productModelArrayList.add(productModel);


            /**
             * Store Purchase Event Details For Passing Data To Adbrix Remaster Back-end.
             * */
            AdBrixRm.Common.purchase(orderId, productModelArrayList, 0.00, 0.00, AdBrixRm.CommercePaymentMethod.CreditCard);

        }catch (Exception e){
            Log.e(LOG_TAG, "parameter error w/ " + e.getMessage());
        }
    }


        @JavascriptInterface
        public void productView(String productId, String productName, double price, int quantity, String currencyCode, String category) {

            try {
                Log.d(LOG_TAG, "GET PRODUCT_VIEW EVENT DATA FROM WEB WITH BELOW DATAS  ::: "
                        + "\n  productId :: " + productId
                        + "\n  productName :: " + productName
                        + "\n  price :: " + price
                        + "\n  quantity :: " + quantity
                        + "\n  discount :: n/a"
                        + "\n  currencyCode :: " + currencyCode
                        + "\n  category :: " + category);

                /**
                 * Create Product Model With Product Details
                 * */
                AdBrixRm.CommerceProductModel productModel =
                        new AdBrixRm.CommerceProductModel().setProductID(productId)
                                .setProductName(productName)
                                .setCategory(new AdBrixRm.CommerceCategoriesModel().setCategory(category))
                                .setPrice(price)
                                .setQuantity(quantity)
                                .setCurrency(AdBrixRm.Currency.getCurrencyByCurrencyCode(currencyCode));

                /**
                 * Store ProductView Event Details For Passing Data To Adbrix Remaster Back-end.
                 * */
                AdBrixRm.Commerce.productView(productModel);


            }catch (Exception e){
                Log.e(LOG_TAG, "parameter error w/ " + e.getMessage());
            }
        }


        @JavascriptInterface
        public void addToCart(String productId, String productName, double price, int quantity, String currencyCode, String category){

            try {
                Log.d(LOG_TAG, "GET ADD_TO_CART EVENT DATA FROM WEB WITH BELOW DATAS  ::: "
                        + "\n  productId :: " + productId
                        + "\n  productName :: " + productName
                        + "\n  price :: " + price
                        + "\n  quantity :: " + quantity
                        + "\n  discount :: n/a"
                        + "\n  currencyCode :: " + currencyCode
                        + "\n  category :: " + category);

                /**
                 * Create Product Model List For AddToCart Event Products Details
                 * */
                ArrayList productModelArrayList = new ArrayList<>();

                /**
                 * Create Product Model With Product Details
                 * */
                AdBrixRm.CommerceProductModel productModel =
                        new AdBrixRm.CommerceProductModel().setProductID(productId)
                                .setProductName(productName)
                                .setCategory(new AdBrixRm.CommerceCategoriesModel().setCategory(category))
                                .setPrice(price)
                                .setQuantity(quantity)
                                .setCurrency(AdBrixRm.Currency.getCurrencyByCurrencyCode(currencyCode));

                /**
                 * Put The Added Product Details Into Product Model List
                 * */
                productModelArrayList.add(productModel);


                /**
                 * Store AddToCart Event Details For Passing Data To Adbrix Remaster Back-end.
                 * */
                AdBrixRm.Commerce.addToCart(productModelArrayList);


            }catch (Exception e){
                Log.e(LOG_TAG, "parameter error w/ " + e.getMessage());
            }
        }


        @JavascriptInterface
        public void viewList(String productId, String productName, double price, int quantity, String currencyCode, String category){

            try {
                Log.d(LOG_TAG, "GET VIEW_LIST EVENT DATA FROM WEB WITH BELOW DATAS  ::: "
                        + "\n  productId :: " + productId
                        + "\n  productName :: " + productName
                        + "\n  price :: " + price
                        + "\n  quantity :: " + quantity
                        + "\n  discount :: n/a"
                        + "\n  currencyCode :: " + currencyCode
                        + "\n  category :: " + category);

                /**
                 * Create Product Model List For ListView Event Products Details
                 * */
                ArrayList productModelArrayList = new ArrayList<>();

                /**
                 * Create Product Model With Product Details
                 * */
                AdBrixRm.CommerceProductModel productModel =
                        new AdBrixRm.CommerceProductModel().setProductID(productId)
                                .setProductName(productName)
                                .setCategory(new AdBrixRm.CommerceCategoriesModel().setCategory(category))
                                .setPrice(price)
                                .setQuantity(quantity)
                                .setCurrency(AdBrixRm.Currency.getCurrencyByCurrencyCode(currencyCode));

                /**
                 * Put The Listed Product Details Into Product Model List
                 * */
                productModelArrayList.add(productModel);


                /**
                 * Store ListView Event Details For Passing Data To Adbrix Remaster Back-end.
                 * */
                AdBrixRm.Commerce.listView(productModelArrayList);


            }catch (Exception e){
                Log.e(LOG_TAG, "parameter error w/ " + e.getMessage());
            }
        }


        @JavascriptInterface
        public void addToWishList(String productId, String productName, double price, int quantity, String currencyCode, String category) {

            try {
                Log.d(LOG_TAG, "GET ADD_TO_WISH_LIST EVENT DATA FROM WEB WITH BELOW DATAS  ::: "
                        + "\n  productId :: " + productId
                        + "\n  productName :: " + productName
                        + "\n  price :: " + price
                        + "\n  quantity :: " + quantity
                        + "\n  discount :: n/a"
                        + "\n  currencyCode :: " + currencyCode
                        + "\n  category :: " + category);

                /**
                 * Create Product Model With Product Details
                 * */
                AdBrixRm.CommerceProductModel productModel =
                        new AdBrixRm.CommerceProductModel().setProductID(productId)
                                .setProductName(productName)
                                .setCategory(new AdBrixRm.CommerceCategoriesModel().setCategory(category))
                                .setPrice(price)
                                .setQuantity(quantity)
                                .setCurrency(AdBrixRm.Currency.getCurrencyByCurrencyCode(currencyCode));

                /**
                 * Store AddToWishList Event Details For Passing Data To Adbrix Remaster Back-end.
                 * */
                AdBrixRm.Commerce.addToWishList(productModel);


            }catch (Exception e){
                Log.e(LOG_TAG, "parameter error w/ " + e.getMessage());
            }
        }


        @JavascriptInterface
        public void share(String sharingChannel, String productId, String productName, double price, int quantity, String currencyCode, String category) {

            try {
                Log.d(LOG_TAG, "GET SHARE EVENT DATA FROM WEB WITH BELOW DATAS  ::: "
                        + "\n  productId :: " + productId
                        + "\n  productName :: " + productName
                        + "\n  price :: " + price
                        + "\n  quantity :: " + quantity
                        + "\n  discount :: n/a"
                        + "\n  currencyCode :: " + currencyCode
                        + "\n  category :: " + category);

                /**
                 * Create Product Model With Product Details
                 * */
                AdBrixRm.CommerceProductModel productModel =
                        new AdBrixRm.CommerceProductModel().setProductID(productId)
                                .setProductName(productName)
                                .setCategory(new AdBrixRm.CommerceCategoriesModel().setCategory(category))
                                .setPrice(price)
                                .setQuantity(quantity)
                                .setCurrency(AdBrixRm.Currency.getCurrencyByCurrencyCode(currencyCode));

                /**
                 * Find SharingChannel Enum With sharingChannel String.
                 * */
                String[] validChannelList = {"Facebook", "KakaoTalk", "KakaoStory", "Line", "whatsApp", "QQ", "WeChat", "SMS", "Email", "copyUrl", "ETC"};

                for(String channel : validChannelList) {

                    if(channel.equals(sharingChannel)){
                        /**
                         * Store Share Event Details For Passing Data To Adbrix Remaster Back-end with Pre-defined Channel Code.
                         * */
                        AdBrixRm.Commerce.share(AdBrixRm.CommerceSharingChannel.getChannelByChannelCode(sharingChannel), productModel);
                    }else{
                        /**
                         * Store Share Event Details For Passing Data to Adbrix Remaster Back-end with ETC Channel Code.
                         * */
                        AdBrixRm.Commerce.share(AdBrixRm.CommerceSharingChannel.ETC, productModel);
                    }
                }
            }catch (Exception e){
                Log.e(LOG_TAG, "parameter error w/ " + e.getMessage());
            }
        }


        @JavascriptInterface
        public void search(String keyword, String productId, String productName, double price, int quantity, String currencyCode, String category) {

            try {

                Log.d(LOG_TAG, "GET SEARCH EVENT DATA FROM WEB WITH BELOW DATAS  ::: " +
                        "  \n  keyword :: " + keyword
                        + "\n  productId :: " + productId
                        + "\n  productName :: " + productName
                        + "\n  price :: " + price
                        + "\n  quantity :: " + quantity
                        + "\n  discount :: n/a"
                        + "\n  currencyCode :: " + currencyCode
                        + "\n  category :: " + category);

                /**
                 * Create Product Model List For Searched Products Details
                 * */
                ArrayList productModelArrayList = new ArrayList<>();

                /**
                 * Create Product Model With Product Details
                 * */
                AdBrixRm.CommerceProductModel productModel =
                        new AdBrixRm.CommerceProductModel().setProductID(productId)
                                .setProductName(productName)
                                .setCategory(new AdBrixRm.CommerceCategoriesModel().setCategory(category))
                                .setPrice(price)
                                .setQuantity(quantity)
                                .setCurrency(AdBrixRm.Currency.getCurrencyByCurrencyCode(currencyCode));

                /**
                 * Put The Searched Product Details Into Product Model List
                 * */
                productModelArrayList.add(productModel);


                /**
                 * Store Search Event Details For Passing Data To Adbrix Remaster Back-end.
                 * */
                AdBrixRm.Commerce.search(keyword, productModelArrayList);

            } catch (Exception e) {
                Log.e(LOG_TAG, "parameter error w/ " + e.getMessage());
            }
        }
    }

    public void AdbrixRmInit(){
        /*
         * Event Upload Interval Setting.
         * */
        AdBrixRm.setLogLevel(AdBrixRm.AdBrixLogLevel.ERROR);
        AdBrixRm.setEventUploadCountInterval(AdBrixRm.AdBrixEventUploadCountInterval.MIN);
        AdBrixRm.setEventUploadTimeInterval(AdBrixRm.AdBrixEventUploadTimeInterval.MIN);
        Log.d(LOG_TAG, "Adbrix Initialize Setting");
    }

}
