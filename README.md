# AdBrixRemasterHybridSample


### 애드브릭스 리마스터 하이브리드 연동 가이드  

본 가이드는 하이브리드 앱에서 애드브릭스 리마스터 SDK를 호출하기 위한 Javascript Interface 구축을 설명합니다.  
애드브릭스 리마스터를 연동하는데 필요한 기본적인 연동사항들은 [Help Center](http://help.adbrix.io)를 참고해주세요.  
<br>



------



### 1. WEB PAGE
<br>

### 1.1. For Android 

웹에서 발생한 이벤트 정보를 ANDROID NATIVE 로 전달하여야 합니다.  

~~~javascript
window.[name].[method](var param);
~~~

위와 같은 방식으로 호출하며, 예제에서는 다음과 같이 AdBrix Remaster Login api를 호출하였습니다.  

~~~javascript
window.adbrix_rm_11st.login("login_information_data");
~~~

<br>



### 1.2. For iOS

웹에서 발생한 이벤트 정보를 iOS NATIVE 로 전달하여야 합니다.

```javascript
window.location("[name]://[method]?[key]=[param]");
```

위와 같은 방식으로 호출하며, 예제에서는 다음과 같이 AdBrix retention api를 호출하였습니다.

```javascript
window.location("adbrix_rm_11st://ret?activity=sample_data")
```

<br>



------



### 2. ANDROID NATIVE
웹에서 전달한 이벤트를 수신하여 적절한 AdBrixRm api를 호출합니다.  
webview 에 javascript interface 를 추가하여 웹에서 호출하는 자바스크립트 이벤트를 캐치할 수 있습니다.

~~~java
webView.addJavascriptInterface(abxRmHybridInterface, "adbrix_rm_11st");
~~~

> 위 코드의 "adbrix" 는 자바스크립트의 **window.[name].[method] 의 name과 반드시 동일**해야 합니다.

<br>
<br>



------



### 3. iOS NATIVE

웹에서 전달한 이벤트를 수신하여 적절한 AdbrixRm api를 호출합니다.
UIWebView에 javascript interface를 추가하여 웹에서 호출하는 자바스크립트 이벤트를 캐치할 수 있습니다.

```objective-c
- (BOOL)webView:(UIWebView *)webView shouldStartLoadWithRequest:(NSURLRequest *)request
 navigationType:(UIWebViewNavigationType)navigationType
{
    if ([[[request URL] scheme] isEqualToString:@"adbrix_rm_11st"])
    {
     
        NSString *pFunctionName = [[request URL] host];
        NSDictionary *adbrixRmEventDict = [self getURLParmaters:[request URL]];
        NSLog(@"parameters : %@", adbrixRmEventDict);
        
        if([pFunctionName containsString:@"login"])
        {
            /*!
             @abstract
             Login 이벤트일 때 호출한다.
             
             @param activityName  activity name.(mandatory)
             */
            // AdBrix 인스턴스 생성
            AdBrixRm *adbrix = [AdBrixRm sharedInstance] ;
            [adBrix loginWithUserId:@"user_information_data"];
            [AdBrixRm retention: [adbrixEventDict valueForKey:@"activity"]];
        }
        return NO;
    }
    return YES;
}
```
<br>



