	// 获取context path
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;
	var serverContext = basePath;

	// 取得浏览器类型
	var type = navigator.appName
	if (type == "Netscape") {
	    var lang = navigator.language
	} else {
	    var lang = navigator.userLanguage
	}
	// 取得浏览器语言的前两个字母
	var lang = lang.substr(0, 2)
	// 英语
	if (lang == "en") {
	//loadJs(serverContext + '/js/locale/easyui-lang-en.js');
	}
	// 中文
	else if (lang == "zh") {
	//loadJs(serverContext + '/js/locale/easyui-lang-zh_CN.js');
	}
	// 除上面所列的语言
	else {
	//loadJs(serverContext + '/js/locale/easyui-lang-jp.js');
	}
	// 动态加载多语言JS

	function loadJs(file) {
	    var head = $("head").remove("script[role='reload']");
	    $("<scri" + "pt>" + "</scr" + "ipt>").attr({
	        role: 'reload',
	        src: file,
	        type: 'text/javascript'
	    }).appendTo(head);
	}
	// 字符串布尔转换成javascript的布尔型

	function stringToBoolean(string) {
	    switch (string.toLowerCase()) {
	    case "true":
	    case "yes":
	    case "1":
	        return true;
	    case "false":
	    case "no":
	    case "0":
	    case null:
	        return false;
	    default:
	        return Boolean(string);
	    }
	}
	
	$.ajaxSetup({
	    type: 'POST',
	    error: function(XMLHttpRequest, textStatus, errorThrown) { /* 扩展AJAX出现错误的提示 */
	        $.messager.progress('close');
	        $.messager.alert('错误', XMLHttpRequest.responseText.split('<script')[0]);
	    }
	});
	
	function getRandom(n) {
	    return Math.floor(Math.random() * n + 1)
	}
