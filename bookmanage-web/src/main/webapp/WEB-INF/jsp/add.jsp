<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="" id="main">

    <table  border="1" align="center" width="800">
        <thead>
        <tr>
            <th colspan="2">增加图书</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>书名：</td>
            <td><input type="text" name="name"  id="name" ></td>
        </tr>
        <tr>
            <td>作者：</td>
            <td><input type="text" name="author"  id="author"></td>
        </tr>
        <tr>
            <td>出版社：</td>
            <td><input type="text" name="publish"  id="publish"></td>
        </tr>
        <tr>
            <td>出版日期：</td>
            <td><input type="text"  name="publishdate"></td>
        </tr>
        <tr>
            <td>页数</td>
            <td><input type="text"  name="page"></td>
        </tr>
        <tr>
            <td>价格：</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>内容提要：</td>
            <td><input type="text" name="content"></td>
        </tr>

        </tbody>
        <tfoot>
        <tr>
            <td  colspan="2"  align="center"><input type="button"  value="提交"  onclick="mysubmit()"></td>
        </tr>
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
    var Base ={"path":"/bookmanage-web/"};
     function  mysubmit() {

          var  name=$("#name").val();
          var  author=$("#author").val();

          if(name==null ||  name=="") {

              alert("图书名称不能为空！！！");

          }else if(author==null || author =="") {

             alert("作者不能为空！！！");
          }else{

                $.get("doadd".parseUrl(Base.path),$("#main").serialize()).always(init);
          }

    }
    function init(data) {
        var url = "index";
        location.href = url.parseUrl(Base.path);
    }
  
</script>
</body>
</html>