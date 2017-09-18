    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
    <%  
        String path = request.getContextPath();  
        String basePath = request.getScheme() + "://"  
                + request.getServerName() + ":" + request.getServerPort()  
                + path + "/";  
    %>  
      
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
    <head>  
    <base href="<%=basePath%>">  
      
    <title>My JSP 'index.jsp' starting page</title>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">  
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
        <link rel="stylesheet" type="text/css" href="styles.css"> 
        -->  
    <style type="text/css">  
    table {  
        border-collapse: collapse;  
    }  
      
    table td {  
        border: solid 1px;  
        border-color: blue;  
        padding: 0px 0px 0px 10px;  
        text-align: center;  
    }  
      
    a {  
        text-decoration: none;  
    }  
      
    .all {  
        width: 1024px;  
    }  
      
    .show_tab tr td {  
        width: 340px;  
        height: 30px;  
    }  
    </style>  
    </head>  
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>  
    <script type="text/javascript" src="../js/json2.js"></script>  
    <script type="text/javascript">  
        function Userinfo(userId, userName, email, sex,age, creatDate, creatDate) {  
            this.userId = userId;  
            this.userName = userName;  
            this.email = email;  
            this.sex = sex; 
            this.age = age;   
            this.creatDate = creatDate;  
            this.modifyDate = creatDate;  
        }  
        function insert() {  
            alert("h1");
            var action = $("#insertfrom").attr('action');  
           /*  var action ="insert_insert.action"; */
             alert(action);
            var userId = $("#userId").val();  
                alert(userId);
            var userName = $("#userName").val();
            alert(userName);
            var email = $("#email").val();   
            /* var sex = $("input:radio[name=sex]:checked").val(); */  
            var sex = "男";
            var age = $("#age").val();  
            var creatDate = $("#creatDate").val();  
             alert("2");
            var userinsert = new Userinfo(userId, userName, email, sex,age, creatDate, creatDate);  
     alert(userinsert);
            var jsonString = JSON.stringify(userinsert);  
            alert(jsonString);
            alert("3");
            $.ajax({  
                url : action,  
                data : {  
                    "jsonString" : jsonString  
                },  
                type : 'post',  
                async : false,  
                /*complete : function(request, dArra) {  
                    if (request.responseText == 'true') {  
                        alert("成功！");  
                    } else if(request.responseText == 'flase'){  
                        error(request);//失败时的处理方法  
                    }  
      
                }*/  
                success : function(data) {  
                    alert("成功！");  
      
                },  
                error : function(data) {  
                alert("失败！"); 
                //alert(data.responseText);
                    error(data);//失败时的处理方法    
                }  
            });  
      
        }  
      
        function error(data) {  
            var result = data.responseText;  
            if (result != null && result != '') {//后台异常时，并在后台捕获    
                var url = getRootPath() + "/error.jsp";//获取工程路径    
              //  location.href = url;  
                $(document.body).html(result);     
            } else {//后台异常，且没有被捕获    
                var url = getRootPath() + "/error.jsp";//获取工程路径    
                location.href = url;  
            }  
        }  
      
        //js获取项目根路径，如：http://localhost:8099/UniqueduHome    
        function getRootPath() {  
            //获取当前网址，如： http://localhost:8099/UniqueduHome/view/error/notAuthorize.jsp    
            var curWwwPath = window.document.location.href;  
            //获取主机地址之后的目录，如： UniqueduHome/view/error/notAuthorize.jsp    
            var pathName = window.document.location.pathname;  
            var pos = curWwwPath.indexOf(pathName);  
            //获取主机地址，如： http://localhost:8099    
            var localhostPaht = curWwwPath.substring(0, pos);  
            //获取带"/"的项目名，如：/UniqueduHome    
            var projectName = pathName.substring(0,  
                    pathName.substr(1).indexOf('/') + 1);  
            return (localhostPaht + projectName);  
        }  
      
        $(document).ready(function() {  
            //回车事件，添加  
            $(document).keydown(function(event) {  
                if (event.keyCode == 13) {  
                    insert();  
                }  
            });  
            pageNum();  
            select(1);  
        });  
      
        function pageParameter(gotoPage, pageNum) {  
            this.gotoPage = gotoPage;  
            this.pageNum = pageNum;  
        }  
        function select(gotoPage) {  
            //分页的方法:调用的时候传一个参数，要去的页数沟通gotoPage  
            //对gotopage的最大和最小控制  
            if (gotoPage < 1) {  
                gotoPage = 1;  
            }  
            //每页的条数  
            var pageNum = $("#pagenum  option:selected").text();  
            var userPage = new pageParameter(gotoPage, pageNum);  
            var jsonString = JSON.stringify(userPage);  
            $.ajax({  
                url : "insert_selectPage.action",  
                data : {  
                    "jsonString" : jsonString  
                },  
                type : 'post',  
                async : false,  
                success : function(data) {  
                    //var pageModel = JSON.parse(request.responseText);  
                    var pageModel = JSON.parse(data);  
                    zhuiJia(pageModel[0]);  
      
                },  
                error : function(data) {  
                    error(data);//失败时的处理方法    
                }  
            });  
        }  
        function zhuiJia(pageModel) {  
            var showTab = $("#show_tab");  
            var showTr = showTab.find(" tr");  
            for ( var i = 1; i < showTr.length; i++) {  
                showTr.eq(i).remove();  
            }  
      
            for ( var i = 0; i < pageModel.list.length; i++) {  
                var unitOne = $("<tr height='30px'><td class='bacx'>"  
                        + (Number(i) + Number(1))  
                        + "</td><td class='bacx'>"  
                        + pageModel.list[i].username  
                        + "</td><td class='bacx'>"  
                        + pageModel.list[i].sex  
                        + "</td><td class='bacx'><a href='javascript:' id='updateA'>修改</a> |  "  
                        + "<a href='javascript:' id='deleteA'>删除</a></td></tr>");  
                //这里直接在unitOne赋值会出现由于符号导致添加的连接有问题  
                //所以要动态添加  
                var updateA = unitOne.children().last().find("#updateA");  
      
                var deleteA = unitOne.children().last().find("#deleteA");  
                updateA.attr("href", "javascript:queryById('"  
                        + pageModel.list[i].id + "')");  
      
                //这里用onclick不起作用，不知道原因，所以改为href  
                deleteA.attr("href", "javascript:deleteSql('"  
                        + pageModel.list[i].id + "');");  
      
                showTab.append(unitOne);  
      
            }  
            $("#gotoPage").val(pageModel.gotoPage);  
            $("#pageIndex").val(pageModel.gotoPage);  
            $("#pageCount").text(pageModel.pageCount);  
        }  
        //查询条件使用  
        function gotoPage(condition) {  
            var gotopage = $("#pageIndex").val();  
            if (condition == "begin") {  
                gotopage = 1;  
            } else if (condition == "last") {  
                gotopage = Number(gotopage) - Number(1);  
            } else if (condition == "next") {  
                gotopage = Number(gotopage) + Number(1);  
            } else if (condition == "end") {  
                gotopage = $("#pageCount").text();  
            } else if (condition == "input") {  
                gotopage = $("#gotoPage").val();  
            }  
            select(gotopage);  
        }  
        //下拉框改变的方法  
        function pageNum() {  
            var pageSelect = $("#pagenum");  
            pageSelect.change(function() {  
                select(1);  
            });  
        }  
        function deleteSql(id) {  
            if (confirm('确定删除？')) {  
                $.ajax({  
                    url : "insert_deleteById.action",  
                    data : {  
                        "jsonString" : id  
                    },  
                    type : 'post',  
                    async : false,  
                    complete : function(request, dArra) {  
                        if (request.responseText == 'true') {  
                            select(1);  
                            //$(obj).parent().parent().remove();  
                        } else {  
                            error(data);//失败时的处理方法    
                        }  
                    }  
                });  
            } else {  
                alert('取消');  
            }  
      
        }  
        function queryById(id) {  
            $.ajax({  
                url : "insert_queryById.action",  
                data : {  
                    "jsonString" : id  
                },  
                type : 'post',  
                async : false,  
                success : function(data) {  
                    var userinfo = JSON.parse(data)[0];  
                    $("#userId").val(userinfo.id);  
                    $("#name").val(userinfo.username);  
                    $("input:radio[name=sex][value=" + userinfo.sex + "]").attr(  
                            "checked", true);  
                    $("#message").val(userinfo.message);  
      
                },  
                error : function(data) {  
                    error(data);//失败时的处理方法    
                }  
      
            });  
        }  
        function update() {  
            var name = $("#name").val();  
            var sex = $("input:radio[name=sex]:checked").val();  
            var userId = $("#userId").val();  
            var password = $("#password").val();  
            var birthday = $("#birthday").val();  
            var message = $("#message").val();  
            var userinsert = new user(userId, name, password, sex, birthday,  
                    message);  
            var jsonString = JSON.stringify(userinsert);  
            $.ajax({  
                url : "insert_update.action",  
                data : {  
                    "jsonString" : jsonString  
                },  
                type : 'post',  
                async : false,  
                /*complete : function(request, dArra) {  
                    if (request.responseText == 'true') {  
                        alert("成功！");  
                    } else if(request.responseText == 'flase'){  
                        error(request);//失败时的处理方法  
                    }  
      
                }*/  
                success : function(data) {  
                    alert("成功！");  
      
                },  
                error : function(data) {  
                    error(data);//失败时的处理方法    
                }  
            });  
      
        }  
    </script>  
    <body>  
        <div class="all">  
            <div>  
                <form action="insert_insert.action" method="post" id="insertfrom"  
                    enctype="multipart/form-data">  
                    <table style="width:100%;">  
                        <tr>  
                            <td style="width:10%; height:40px;">userName：</td>  
                            <td style="width:20%; height:40px;">
                            <input type="hidden" value="" id="userId" /> 
                            <input type="text" name="userName" id="userName" /></td>  
                            
                            <td style="width:10%; height:40px;">email：</td>  
                            <td style="width:20%; height:40px;">
                            <input type="text" name="email" id="email" /></td>  
                            
                            <td style="width:10%; height:40px;">sex：</td>  
                            <td style="width:29%; height:40px;">
                            <input type="radio" name="sex" value="男" />男  
                            <input type="radio" name="sex" value="女" />女</td>  
      
                        </tr> 
                         
                        <tr>  
                            <td style="width:10%; height:40px;">age：</td>  
                            <td style="width:20%; height:40px;">
                            <input type="text" name="age" id="age" /></td> 
                             
                            <td style="width:10%; height:40px;">creatDate：</td>  
                            <td style="width:20%; height:40px;">
                            <input type="text" name="creatDate" id="creatDate" /></td>  
                            
                            <td colspan="2" style="width:29%; height:40px;">
                            <input  type="button" onclick="insert()" value="保存"> 
                            <input  type="button" onclick="update()" value="修改"> </td>  
                            
                        </tr>  
                    </table>  
                </form>
                  
                <form action="pic_insertPic.action" method="post" id="insertfrom"  
                    enctype="multipart/form-data">  
                    <input type="hidden" value="" id="userId" name="userId"/>  
                    <table style="width:100%;">  
                        <tr>  
                            <td style="width:20%; height:40px;">文件：</td>  
                            <td style="width:50%; height:40px;">
                            <input type="file"name="photo" id="photo" /></td>  
      
                            <td style="width:20%; height:40px;">
                            <input type="submit" value="保存"></td>  
                        </tr>  
                    </table>  
                </form>  
            </div>
            
              
            <div>  
                <table class="show_tab" id="show_tab">  
                    <tr>  
                        <td>编号</td>  
                        <td>姓名</td>  
                        <td>性别</td>  
                        <td>年龄</td>
                        <td>邮箱</td>
                        <td>操作</td>  
                    </tr>  
                    <tr>  
                        <td>编号</td> 
                        <td>name</td>  
                        <td>男</td> 
                        <td>12</td>
                        <td>w@qq.com</td> 
                        <td><a href="#">修改  </a><a href="#">删除</a>  
                        </td>  
                    </tr>  
                </table>  
            </div>  
            <div  
                style="width:100%; height:35px; background: silver; line-height: 35px; color:blue;">  
                <a href="javascript:gotoPage('begin');">首页<a />    
            <a href="javascript:gotoPage('last');">上一页<a/>   
            <a href="javascript:gotoPage('next');" >下一页<a/>   
            <a href="javascript:gotoPage('end');">末尾</a> |   
            <input type="hidden" value="" id="pageIndex">  
            <input type="text" style="width:40px;" id="gotoPage" value="" /> / <span id="pageCount">1</span>页  
            <a href="javascript:gotoPage('input');" >跳转</a> | 每页  
            <select id="pagenum">  
            <option>10</option>  
            <option>20</option>  
            <option>50</option>  
            <option>100</option>  
            </select>条  
            </div>  
        </div>  
    </body>  
    </html>  