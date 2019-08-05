<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action=""  id="ff">


    <table border="1"  align="center"  width="800">
        <thead>
        <tr>
            <th colspan="2">图书管理系统</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="button" value="登录" onclick="mysubmit()"></td>
        </tr>
        </tbody>
        <tfoot>

        </tfoot>
    </table>

</form>

<script  src="${pageContext.request.contextPath }/statics/js/jquery/jquery-1.12.4.min.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/jquery/jquery.cookie.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/jquery/jquery.form.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/common/base.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/common/normal.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/moment/moment.min.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/numeral/chs.min.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/numeral/numeral.min.js"></script>

<script>

    var  Base={"path":"/bookmanage-web/"};

    function  mysubmit() {
       
    
        $.get("login".parseUrl(Base.path),$("#ff").serialize()).always(checkname);
   
    }


     function  checkname(data) {
      
    	
         var result=$.dealJSONObj(data);
      
         if(result.code==0){
              var url="index";
             location.href=url.parseUrl(Base.path);

         }else{
        	 
             var temp="<tr><td bgcolor='red'>"+result.msg+"</td></tr>";

            $("tfoot").html(temp);

         }


     }
</script>
</body>
</html>