ModalDialog = function(){
    var objDiv = null;
    var baseDiv = null;
    var iframe = null
    var that = this;
    //对象初值设定画面
    this.openPopWindow = function(param){
            iframe = document.createElement("iframe");
            iframe.style.position = "absolute";
            iframe.style.zIndex = "9";
            iframe.style.display="block";
            iframe.className = "rm_div2";
            iframe.style.pixelLeft = 0;
            iframe.style.pixelTop = 0;
            iframe.style.pixelHeight = document.body.clientHeight;
            iframe.style.pixelWidth = document.body.clientWidth;
            document.body.insertAdjacentElement("beforeEnd",iframe);
            baseDiv = document.createElement("DIV");
            baseDiv.style.position = "absolute";
            baseDiv.style.zIndex = "9";
            baseDiv.style.display="block";
            baseDiv.className = "rm_div2";
            baseDiv.style.pixelLeft = 0;
            baseDiv.style.pixelTop = 0;
            baseDiv.style.pixelHeight = document.body.clientHeight;
            baseDiv.style.pixelWidth = document.body.clientWidth;
            document.body.insertAdjacentElement("beforeEnd",baseDiv);
            objDiv = document.createElement("DIV");
            objDiv.style.position = "absolute";
            objDiv.style.display="block";
            objDiv.style.zIndex = "10";
            objDiv.className = "rm_div1";
//            objDiv.style.pixelWidth = 300;
//            objDiv.style.pixelHeight = 200;
//            objDiv.style.overflowY="auto";
            document.body.insertAdjacentElement("beforeEnd",objDiv);
            var objTab = creactTable(param);
            objDiv.appendChild(objTab);
            var objTr = objTab.insertRow(-1);
            var objTd = objTr.insertCell(-1);
            objTd.style.padding = "5px 0px 5px 0px";
            objTd.align = "center";
            var inputButt = document.createElement("input");
            inputButt.type = "button";
            inputButt.style.padding = "0px 15px 0px 15px";
            inputButt.value = "确定";
            inputButt.onclick = closePopWindow;
            objTd.appendChild(inputButt);
            objDiv.style.pixelLeft = (document.body.clientWidth - document.body.scrollLeft - objDiv.offsetWidth)/2;
            objDiv.style.pixelTop = (document.body.clientHeight - document.body.scrollTop - objDiv.offsetHeight)/2;
            inputButt.focus();
    };

    var creactTable = function(param){
        var objTab = document.createElement("TABLE");
        objTab.style.pixelWidth = 300;
        objTab.setAttribute("frame",'void');
        objTab.style.borderCollapse = 'collapse';
        var objTr = objTab.insertRow(-1);
        objTr.style.fontSize = "12px";
        objTr.style.color = "#ffffff";
        objTr.style.backgroundColor = "#336699";
        var objTd = objTr.insertCell(-1);
        objTd.innerText = "消息提示窗口";
        objTd.style.padding = "5px 5px 5px 5px";
        var bodyTab = document.createElement("TABLE");
        bodyTab.style.pixelWidth = 300;
        bodyTab.setAttribute("frame",'void');
        bodyTab.style.borderCollapse = 'collapse';
        for(var i=0;i<param.length;i++){
            objTr = bodyTab.insertRow(-1);
            objTr.style.fontSize = "9pt";
            objTd = objTr.insertCell(-1);
            objTd.style.padding = "5px 0px 5px 20px";
            objTd.innerText = "* "+param[i];
        }
        var bodyDiv = document.createElement("DIV");
        bodyDiv.style.display="block";
        bodyDiv.style.pixelHeight = 150;
        bodyDiv.style.overflowY="auto";
        bodyDiv.appendChild(bodyTab);
        objTr = objTab.insertRow(-1);
        objTd = objTr.insertCell(-1);
        objTd.noWrap = "noWrap";
        objTd.appendChild(bodyDiv);
        return objTab;
    };

    //动态弹出页面的确定处理
    var confirmPopWindow = function (){
        closePopWindow();
    };

    //动态弹出页面的取消处理
    var closePopWindow = function (){
        if(objDiv!=null) {
            objDiv.removeNode(true);
        }
        if(baseDiv!=null) {
            baseDiv.removeNode(true);
        }
        if(iframe!=null) {
            iframe.removeNode(true);
        }
    };
}