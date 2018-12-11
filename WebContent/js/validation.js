/**
 * @author wxw
 */
validation = Class.create();
validation.construct = function() {
	var message = new Array();
	this.Validate = function(thisFrom){
        var obj = thisFrom || event.srcElement;
        var count = obj.elements.length;
        for(var i=0;i<count;i++){
            with(obj.elements[i]){
                var _dataType = getAttribute("dataType");
                value = value.replace(/(^\s*)|(\s*$)/g, "");
                if(getAttribute("require") == "false" && value == "" || getAttribute("disabled") == true) continue;
                if(!isNull(value) && _dataType != null){
                     var meg = ValidationErrorString["required"];
                     meg = meg.replace("{0}",getAttribute("cn_name"));
                     message.push(meg);
                     setBgColor(obj.elements[i]);
                     continue;
                 } else {
                    removeBgColor(obj.elements[i]);
                }
                switch(_dataType){
                    case "num" :
                         if(!isNumber(value)){
                             var meg = ValidationErrorString[_dataType];
                             meg = meg.replace("{0}",getAttribute("cn_name"));
                             message.push(meg);
                             setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                        }
                         break;
                    case "eng" :
                         if(!isEng(value)){
                             var meg = ValidationErrorString[_dataType];
                             meg = meg.replace("{0}",getAttribute("cn_name"));
                             message.push(meg);
                          setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                         break;
                    case "engNum" :
                         if(!isEngNum(value)){
                             var meg = ValidationErrorString[_dataType];
                             meg = meg.replace("{0}",getAttribute("cn_name"));
                             message.push(meg);
                          setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                         break;
                    case "normal" :
                         if(!isNormal(value)){
                             var meg = ValidationErrorString[_dataType];
                             meg = meg.replace("{0}",getAttribute("cn_name"));
                             message.push(meg);
                          setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                         break;
                    case "int" :
                         if(isInteger(value)){
                             var meg = ValidationErrorString[_dataType];
                             meg = meg.replace("{0}",getAttribute("cn_name"));
                             message.push(meg);
                          setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                         break;
                     case "integer" :
                         if(isIntegerNumber(value)){
                             var meg = ValidationErrorString[_dataType];
                             meg = meg.replace("{0}",getAttribute("cn_name"));
                             message.push(meg);
                          setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                         break;
                    case "intScope" :
                         if(!isIntegerScope(value,obj.elements[i])){
                             var meg = ValidationErrorString[_dataType];
                             meg = meg.replace("{0}",getAttribute("cn_name"));
                             meg = meg.replace("{1}",getAttribute("minNum"));
                             meg = meg.replace("{2}",getAttribute("maxNum"));
                             message.push(meg);
                          setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                         break;
                    case "double" :
                        if(!isDouble(value)){
                             var meg = ValidationErrorString[_dataType];
                             meg = meg.replace("{0}",getAttribute("cn_name"));
                             message.push(meg);
                         setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                        break;
                     case "doublerScope" :
                         if(!isDoublerScope(value,obj.elements[i])){
                             var meg = ValidationErrorString[_dataType];
                             meg = meg.replace("{0}",getAttribute("cn_name"));
                             meg = meg.replace("{1}",getAttribute("minNum"));
                             meg = meg.replace("{2}",getAttribute("maxNum"));
                             message.push(meg);
                          setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                         break;
                     case "floatScope" :
                         if(!isFloatScope(value,obj.elements[i])){
                             var meg = ValidationErrorString[_dataType];
                             meg = meg.replace("{0}",getAttribute("cn_name"));
                             meg = meg.replace("{1}",getAttribute("IntNum"));
                             meg = meg.replace("{2}",getAttribute("DecimalNum"));
                             message.push(meg);
                          setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                         break;
                    case "required" :
                        if(!isNull(value)){
                             var meg = ValidationErrorString[_dataType];
                             meg = meg.replace("{0}",getAttribute("cn_name"));
                             message.push(meg);
                          setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                         break;
                    case "pid" :
                        if(!RegExp_idCard(value)){
                             var meg = ValidationErrorString[_dataType];
                             message.push(meg);
                         setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                        break;
                    case "date" :
                        if(!RegExp_time(value)){
                             var meg = ValidationErrorString[_dataType];
                             meg = meg.replace("{0}",getAttribute("cn_name"));
                             meg = meg.replace("{1}",getAttribute("format"));
                             message.push(meg);
                         setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                        break;
                    case "sting" :
                        if(!isEng(value)){
                             var meg = ValidationErrorString[_dataType];
                             meg = meg.replace("{0}",getAttribute("cn_name"));
                             message.push(meg);
                         setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                        break;
                    case "phone" :
                        if(!isPhone(value)){
                             var meg = ValidationErrorString[_dataType];
                             message.push(meg);
                         setBgColor(obj.elements[i]);
                         } else {
                            removeBgColor(obj.elements[i]);
                         }
                        break;
                    default :
                        break;
                }
            }
        }
        if(message.length!=0){
            var str = "";
            for(var i=0;i<message.length;i++){
                str += message[i];
            }
            var dialog = new ModalDialog();
            dialog.openPopWindow(message);
            message.splice(0,message.length);
            return false;
        }
        else
            return true;

    };

    var setBgColor = function(obj){
          obj.style.backgroundColor = "#EEEEEE";
          obj.style.border = "1 #CADAF9 solid";
    }

    var removeBgColor = function(obj){
         obj.removeAttribute("style");
    }
    var isNull = function(str)
	{
        var reg = /(\s|　)+/gi;
        str = str.replace(reg,'');
        var regTextNull = /.+/;
        return regTextNull.test(str);
	};

    var isEng = function(str)
    {
		var regTextEng = /^[a-zA-Z]*$/;
		return regTextEng.test(str);
    };

    var isNumber = function(str)
	{   if(isNull(str)){
           var regTextInteger = /^[0-9]*$/;
           return regTextInteger.test(str);
        }
        return false;
    };

    var isInteger = function(str)
	{
        var regTextInteger = /^[^0](\d)*$/;
        if(isNumber(str)){
//            if(str.length == 1)
//                return false;
            return !regTextInteger.test(str);
        }
        return true;
    };
    
    var isIntegerNumber= function(str)
    {	
    	var regTextInteger = /^-?\d+$/;
        return !regTextInteger.test(str);
    }

    var isIntegerScope = function(str,obj)
	{
        if(isNumber(str)){

          var minNum = obj.getAttribute("minNum");
          var maxNum = obj.getAttribute("maxNum");
          return (parseInt(str)>= parseInt(minNum) && parseInt(str)<= parseInt(maxNum))
        }
        return false;
	};

     var isPhone = function(str)
	{
//        var regTextPhone = /^[0-9]{3,4}\-[0-9]{3,8}$/;
        var regTextPhone = /^[0-9\-]*$/;
        return regTextPhone.test(str);
	};


     var isDouble = function(str)
	{
        var regTextDouble = /^[\-\+]?([0-9]\d*|0|[1-9]\d{0,2}(,\d{3})*)(\.\d+)?$/;
        var regTextfirst = /^[^0](\d)*$/
        if(regTextDouble.test(str)){
            var length = str.length;
            if(str.indexOf('.') != -1)
                length = str.indexOf('.');
            str = str.substring(0,length);
            if(str.length>1)
               return regTextfirst.test(str);
            else
               return true;
        }
        return false;
	};

     var isDoublerScope = function(str,obj)
	{
        if(isDouble(str)){
            var length = str.length;
            if(str.indexOf('.') != -1)
                length = str.indexOf('.');
            str = str.substring(0,length);
            var minNum = obj.getAttribute("minNum");
            var maxNum = obj.getAttribute("maxNum");
            return (parseInt(str)>= parseInt(minNum) && parseInt(str)<= parseInt(maxNum))
        }
        return false;
    };

     var isFloatScope = function(str,obj)
	{
        if(isDouble(str)){
            var intNum = obj.getAttribute("IntNum");
            var decimalNum = obj.getAttribute("DecimalNum");
            var length = str.length;
            if(str.indexOf('.') != -1){
                if(parseInt(length - str.indexOf('.') -1) > parseInt(decimalNum))
                    return false;
                length = str.indexOf('.');
            }
            if(length > parseInt(intNum))
               return false;
            return true;
        }
        return false;
    };

    var isNormal = function(str)
	{
        var regTextChar = /([\"\'<>\/])+/;
        return !regTextChar.test(str);
    };
    
    var isEngNum = function(str)
    {
		var regTextEngNum = /^[a-zA-Z0-9]*$/;
		return regTextEngNum.test(str);    	
    };

    //英文数字
    var engNumSpe = function(str)
	{
	    var reg = /^([a-zA-Z0-9]|[._+*%<>()=\"\'\s])*$/;
		return reg.test(str);    	
	};
	
	/**
     *  时间验证
     */
    var RegExp_time = function(t) {
        if(!/\d{4}-\d{1,2}-\d{1,2}/.test(t))
            return false;
        var MonthDays = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
        var tempArray = t.split("-");
        var year = tempArray[0];
        var month = tempArray[1];
        var day = tempArray[2];
        if(year <=0 || year > 9999)
            return false;
        if(month <=0 || month > 12)
            return false;
        var rightDay = 0;
        if(month == 2)
            rightDay = ((year%4 == 0) && (year%100 != 0)||(year%400 == 0)) ? 29 : 28;
        else
            rightDay = MonthDays[month - 1];
        if(day <= 0 || day > rightDay)
            return false;
        return true;
    };
    
    
    /**
     *	身份证验证
     */
    var RegExp_idCard = function(sId) {
    	var aCity={11:'北京',12:'天津',13:'河北',14:'山西',15:'内蒙古',21:'辽宁',22:'吉林',23:'黑龙江',31:'上海',32:'江苏',33:'浙江',34:'安徽',35:'福建',36:'江西',37:'山东',41:'河南',42:'湖北',43:'湖南',44:'广东',45:'广西',46:'海南',50:'重庆',51:'四川',52:'贵州',53:'云南',54:'西藏',61:'陕西',62:'甘肃',63:'青海',64:'宁夏',65:'新疆',71:'台湾',81:'香港',82:'澳门',91:'国外'};
		var iSum=0;
		var info='';
        if(sId.length == 15){
            if(!/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/.test(sId))
                return false;
            else {
                if(aCity[parseInt(sId.substr(0,2))]==null)
			        return false;
                return true;
            }
        }
        if(!/^\d{17}(\d|x)$/i.test(sId))
			return false; 
		sId=sId.replace(/x$/i,"a"); 
		if(aCity[parseInt(sId.substr(0,2))]==null)
			return false;
		var sBirthday=sId.substr(6,4)+"/"+Number(sId.substr(10,2))+"/"+Number(sId.substr(12,2));
		var d=new Date(sBirthday);
		if(sBirthday!=(d.getFullYear()+"/"+ (d.getMonth()+1) + "/" + d.getDate()))
			return false; 
		for(var i = 17;i>=0;i--)
			iSum += (Math.pow(2,i) % 11) * parseInt(sId.charAt(17 - i),11) 
		if(iSum%11!=1)
			return false; 
		return true;
    };
    var ValidationErrorString = new Object();
	ValidationErrorString = new Object();
	ValidationErrorString["default"]="域{0}校验失败。";
	ValidationErrorString["required"]="{0}不能为空。";
	ValidationErrorString["num"]="{0}必须是数字。";
    ValidationErrorString["int"]="{0}必须是一个整数，且必须大于0。";
    ValidationErrorString["integer"]="{0}必须是一个整数。";
    ValidationErrorString["string"]="{0}必须是英文字母。";
    ValidationErrorString["phone"]="电话号码不正确。";
    ValidationErrorString["double"]="{0}必须是一个浮点数（带小数点）。";
	ValidationErrorString["commonchar"] = "{0}必须是普通英文字符：字母，数字和下划线。";
	ValidationErrorString["chinesechar"] = "{0}必须是中文字符。";
    ValidationErrorString["engNum"] = "{0}必须是英文或数字。";
    ValidationErrorString["minlength"]="{0}长度不能小于{1}个字符。";
	ValidationErrorString["maxlength"]="{0}长度不能大于{1}个字符。" ;
	ValidationErrorString["invalid"]="{0}无效。";
    ValidationErrorString["normal"]="{0}中存在无效字符。";
    ValidationErrorString["date"]="{0}不是一个有效日期，期待格式：{1}。";
	ValidationErrorString["intScope"]="{0}必须在整数{1}和{2}之间。";
	ValidationErrorString["doublerScope"]="{0}必须在浮点数{1}和{2}之间。";
    ValidationErrorString["floatScope"]="{0}不是个有效的浮点数，整数不能超过{1}位，小数不能超过{2}位。";
    ValidationErrorString["pid"]="不是一个有效身份证号。";
	ValidationErrorString["email"]="{0}不是一个有效的Email。";
	ValidationErrorString["equalsfield"]="{0}必须和{1}一致。";
};
var clicked = new validation();
document.oncontextmenu = function(){event.returnValue=false;}//屏蔽鼠标右键

