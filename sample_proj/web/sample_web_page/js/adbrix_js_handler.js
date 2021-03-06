if (!jQuery) { throw new Error("Adbrix Hybrid Sample requires jQuery") }

String.format = function() {
    var str = arguments[0];    
    for (var i = 1; i < arguments.length; i++) {
        var regEx = new RegExp("\\{" + (i - 1) + "\\}", "gm");
        str = str.replace(regEx, arguments[i]);
    }    
    return str;
}

var is_android = false; //initiate as false
var is_ios = false; //initiate as false

var orderId = "";
var productId = "";
var productName = "";
var unitPrice = 0.00;
var quantity = 0;
var discount = 0.00;
var category = "";
var currencyCode = "";
var sharingChannel = "";

$(document).ready(function(){
    if( /Android/i.test(navigator.userAgent)) {
        is_android = true;
        is_ios = false;
        console.log("android device!!!");
    } else if (/iPhone|iPad|iPod/i.test(navigator.userAgent)) {
        is_ios = true;
        is_android = false;
        console.log("ios device!!!");
    } else {
        is_android = false;
        is_ios = false;
        console.log("only support mobile devices!!!");
    }
});

/* Purchase */
$("#purchaseForm").submit(function( event ) {

    orderId = $('#purchaseForm').find('input[id="order_id"]').val();
    productId = $('#purchaseForm').find('input[id="product_id"]').val();
    productName = encodeURIComponent($('#purchaseForm').find('input[id="product_name"]').val());
    unitPrice = $('#purchaseForm').find('input[id="unit_price"]').val();
    quantity = $('#purchaseForm').find('input[id="quantity"]').val();
    discount = $('#purchaseForm').find('input[id="discount"]').val();
    category = encodeURIComponent($('#purchaseForm').find('input[id="product_category"]').val());
    currencyCode = $('#purchaseForm').find('input[id="currency_code"]').val();

    console.log("purchase data ::: " 
        + "\n > orderId :: "  + orderId
        + "\n > productId :: "  + productId
        + "\n > productName :: "  + productName
        + "\n > unitPrice :: "  + unitPrice
        + "\n > quantity :: "  + quantity
        + "\n > currencyCode :: "  + currencyCode
        + "\n > category :: "  + category);

    if(is_android) {
        window.adbrix.purchase(orderId, productId, productName, unitPrice, quantity, currencyCode, category);
    }else if(is_ios){
        var query_form = "orderId={0}&productId={1}&productName={2}&unitPrice={3}&quantity={4}&currencyCode={5}&category={6}";
        window.location.href = "adbrix://purchase?" + String.format(query_form, orderId, productId, productName, unitPrice, quantity, currencyCode, category);
    }else {
        console.log("please test with webview.");
    }
    
    event.preventDefault();
});


/* productView */
$("#productViewForm").submit(function( event ) {

    productId = $('#productViewForm').find('input[id="product_id"]').val();
    productName = encodeURIComponent($('#productViewForm').find('input[id="product_name"]').val());
    unitPrice = $('#productViewForm').find('input[id="unit_price"]').val();
    quantity = $('#productViewForm').find('input[id="quantity"]').val();
    discount = $('#productViewForm').find('input[id="discount"]').val();
    category = encodeURIComponent($('#productViewForm').find('input[id="product_category"]').val());
    currencyCode = $('#productViewForm').find('input[id="currency_code"]').val();

    console.log("productView data ::: "         
        + "\n > productId :: "  + productId
        + "\n > productName :: "  + productName
        + "\n > unitPrice :: "  + unitPrice
        + "\n > quantity :: "  + quantity
        + "\n > currencyCode :: "  + currencyCode
        + "\n > category :: "  + category);

    if(is_android){
        window.adbrix.productView(productId, productName, unitPrice, quantity, currencyCode, category);
    }else if(is_ios){
        var query_form = "productId={0}&productName={1}&unitPrice={2}&quantity={3}&currencyCode={4}&category={5}";
        window.location.href = "adbrix://productView?" + String.format(query_form, productId, productName, unitPrice, quantity, currencyCode, category);
    }else {
        console.log("please test with webview.");     
    }

    event.preventDefault();
});

/* viewList */
$("#viewListForm").submit(function( event ) {

    productId = $('#viewListForm').find('input[id="product_id"]').val();
    productName = encodeURIComponent($('#viewListForm').find('input[id="product_name"]').val());
    unitPrice = $('#viewListForm').find('input[id="unit_price"]').val();
    quantity = $('#viewListForm').find('input[id="quantity"]').val();
    discount = $('#viewListForm').find('input[id="discount"]').val();
    category = encodeURIComponent($('#viewListForm').find('input[id="product_category"]').val());
    currencyCode = $('#viewListForm').find('input[id="currency_code"]').val();

    console.log("viewList data ::: "         
        + "\n > productId :: "  + productId
        + "\n > productName :: "  + productName
        + "\n > unitPrice :: "  + unitPrice
        + "\n > quantity :: "  + quantity
        + "\n > currencyCode :: "  + currencyCode
        + "\n > category :: "  + category);
    
    if(is_android){
        window.adbrix.viewList(productId, productName, unitPrice, quantity, currencyCode, category);
    }else if(is_ios){
        var query_form = "productId={0}&productName={1}&unitPrice={2}&quantity={3}&currencyCode={4}&category={5}";
        window.location.href = "adbrix://viewList?" + String.format(query_form, productId, productName, unitPrice, quantity, currencyCode, category);
    }else {
        console.log("please test with webview.");     
    }

    event.preventDefault();
});

/* addToCart */
$("#addToCartForm").submit(function( event ) {

    productId = $('#addToCartForm').find('input[id="product_id"]').val();
    productName = encodeURIComponent($('#addToCartForm').find('input[id="product_name"]').val());
    unitPrice = $('#addToCartForm').find('input[id="unit_price"]').val();
    quantity = $('#addToCartForm').find('input[id="quantity"]').val();
    discount = $('#addToCartForm').find('input[id="discount"]').val();
    category = encodeURIComponent($('#addToCartForm').find('input[id="product_category"]').val());
    currencyCode = $('#addToCartForm').find('input[id="currency_code"]').val();

    console.log("addToCart data ::: "         
        + "\n > productId :: "  + productId
        + "\n > productName :: "  + productName
        + "\n > unitPrice :: "  + unitPrice
        + "\n > quantity :: "  + quantity
        + "\n > currencyCode :: "  + currencyCode
        + "\n > category :: "  + category);
    
    if(is_android){
        window.adbrix.addToCart(productId, productName, unitPrice, quantity, currencyCode, category);
    }else if(is_ios){
        var query_form = "productId={0}&productName={1}&unitPrice={2}&quantity={3}&currencyCode={4}&category={5}";
        window.location.href = "adbrix://addToCart?" + String.format(query_form, productId, productName, unitPrice, quantity, currencyCode, category);
    }else {
        console.log("please test with webview.");     
    }

    event.preventDefault();
});

/* addToWishList */
$("#addToWishListForm").submit(function( event ) {

    productId = $('#addToWishListForm').find('input[id="product_id"]').val();
    productName = encodeURIComponent($('#addToWishListForm').find('input[id="product_name"]').val());
    unitPrice = $('#addToWishListForm').find('input[id="unit_price"]').val();
    quantity = $('#addToWishListForm').find('input[id="quantity"]').val();
    discount = $('#addToWishListForm').find('input[id="discount"]').val();
    category = encodeURIComponent($('#addToWishListForm').find('input[id="product_category"]').val());
    currencyCode = $('#addToWishListForm').find('input[id="currency_code"]').val();

    console.log("addToWishList data ::: "         
        + "\n > productId :: "  + productId
        + "\n > productName :: "  + productName
        + "\n > unitPrice :: "  + unitPrice
        + "\n > quantity :: "  + quantity
        + "\n > currencyCode :: "  + currencyCode
        + "\n > category :: "  + category);
            
    if(is_android){
        window.adbrix.addToWishList(productId, productName, unitPrice, quantity, currencyCode, category);
    }else if(is_ios){
        var query_form = "productId={0}&productName={1}&unitPrice={2}&quantity={3}&currencyCode={4}&category={5}";
        window.location.href = "adbrix://addToWishList?" + String.format(query_form, productId, productName, unitPrice, quantity, currencyCode, category);
    }else {
        console.log("please test with webview.");     
    }


    event.preventDefault();
});

/* share */
$("#shareForm").submit(function( event ) {

    /**
     * The sharingChannel value must be one of the channel list strings below.
     * Facebook, KakaoTalk, KakaoStory, Line, whatsApp, QQ, WeChat, SMS, Email, copyUrl, ETC
     * 
     */
    sharingChannel = $('#shareForm').find('input[id="sharing_channel"]').val();
    productId = $('#shareForm').find('input[id="product_id"]').val();
    productName = encodeURIComponent($('#shareForm').find('input[id="product_name"]').val());
    unitPrice = $('#shareForm').find('input[id="unit_price"]').val();
    quantity = $('#shareForm').find('input[id="quantity"]').val();
    discount = $('#shareForm').find('input[id="discount"]').val();
    category = encodeURIComponent($('#shareForm').find('input[id="product_category"]').val());
    currencyCode = $('#shareForm').find('input[id="currency_code"]').val();

    console.log("share data ::: "         
        + "\n > sharingChannel :: "  + sharingChannel
        + "\n > productId :: "  + productId
        + "\n > productName :: "  + productName
        + "\n > unitPrice :: "  + unitPrice
        + "\n > quantity :: "  + quantity
        + "\n > currencyCode :: "  + currencyCode
        + "\n > category :: "  + category);
            
    if(is_android){
        window.adbrix.share(sharingChannel, productId, productName, unitPrice, quantity, currencyCode, category);
    }else if(is_ios){
        var query_form = "sharingChannel={0}&productId={1}&productName={2}&unitPrice={3}&quantity={4}&currencyCode={5}&category={6}";
        window.location.href = "adbrix://share?" + String.format(query_form, sharingChannel, productId, productName, unitPrice, quantity, currencyCode, category);
    }else {
        console.log("please test with webview.");     
    }

    event.preventDefault();
});


/* search */
$("#searchForm").submit(function( event ) {

    keyword = encodeURIComponent($('#searchForm').find('input[id="keyword"]').val());
    productId = $('#searchForm').find('input[id="product_id"]').val();
    productName = encodeURIComponent($('#searchForm').find('input[id="product_name"]').val());
    unitPrice = $('#searchForm').find('input[id="unit_price"]').val();
    quantity = $('#searchForm').find('input[id="quantity"]').val();
    discount = $('#searchForm').find('input[id="discount"]').val();
    category = encodeURIComponent($('#searchForm').find('input[id="product_category"]').val());
    currencyCode = $('#searchForm').find('input[id="currency_code"]').val();

    console.log("search data ::: "         
        + "\n > keyword :: "  + keyword
        + "\n > productId :: "  + productId
        + "\n > productName :: "  + productName
        + "\n > unitPrice :: "  + unitPrice
        + "\n > quantity :: "  + quantity
        + "\n > currencyCode :: "  + currencyCode
        + "\n > category :: "  + category);
            
    if(is_android){
        window.adbrix.search(keyword, productId, productName, unitPrice, quantity, currencyCode, category);
    }else if(is_ios){
        var query_form = "keyword={0}&productId={1}&productName={2}&unitPrice={3}&quantity={4}&currencyCode={5}&category={6}";
        window.location.href = "adbrix://search?" + String.format(query_form, sharingChannel, productId, productName, unitPrice, quantity, currencyCode, category);
    }else {
        console.log("please test with webview.");     
    }

    event.preventDefault();
});

