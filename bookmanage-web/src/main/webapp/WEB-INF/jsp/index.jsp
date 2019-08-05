<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书管理系统</title>
</head>
<body>
<table border="1"  width="800" align="center">
    <thead>
    <tr><th colspan="8">图书详细信息列表</th></tr>
    <tr>
        <th>图书编码</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>出版日期</th>
        <th>页数</th>
        <th>价格</th>
        <th>内容摘要</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody></tbody>

   <tfoot><tr><td  colspan="9" id="page"> <input type="button"  value="新增图书"  onclick="addbutton()">
</td></tr> </tfoot>
</table>

<script  src="${pageContext.request.contextPath }/statics/js/jquery/jquery-1.12.4.min.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/jquery/jquery.cookie.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/jquery/jquery.form.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/common/base.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/common/normal.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/moment/moment.min.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/numeral/chs.min.js"></script>
<script  src="${pageContext.request.contextPath }/statics/js/numeral/numeral.min.js"></script>
<script>

    var  Base ={"path":"/bookmanage-web/"};
    $(function () {
    	 var page=$.getHrefParam("page");
        
        $.get("main".parseUrl(Base.path),{page:page}).always(init);
    })

    function  init(data) {
        var result=$.dealJSONObj(data);
        // language=Angular2HTML
        var templist="<tr>\n    <td>{0}</td>\n    <td>{1}</td>\n    <td>{2}</td>\n    <td>{3}</td>\n " +
            "   <td>{4}</td>\n    <td>{5}</td>\n    <td>{6}</td>\n   <td>{7}</td>\n   " +
            " <td><a href=\'javascript:;\' onclick=\'update({0})\'>修改</a>||" +
            "<a href=\'javascript:;\' onclick=\'del({0})\'>删除</a></td>\n</tr>";
        var str="";
        $.each(result.data.list,function (i,n) {
            str+=templist.formatStr(
                n.id,
                n.name,
                n.author,
                n.publish,
                n.publishdate,
                n.page,
                n.price,
                n.content
            )

        });
        $("tbody").html(str);
        // language=Angular2HTML
           var temppage="一共"+result.data.pages+"页&nbsp&nbsp&nbsp&nbsp" +
            "<a href='index?page="+result.data.firstPage+"'>第一页</a>&nbsp&nbsp" +
            "<a href='index?page="+result.data.nextPage+"'>下一页</a>&nbsp&nbsp" +
            "<a href='index?page="+result.data.prePage+"'>上一页</a>&nbsp&nbsp" +
            "<a href='index?page="+result.data.lastPage+"'>最后页</a>" ;

        $("#page").append(temppage);
    }
    
    
    
    function  update(id) {
        var url="modify.html?id="+id;

        location.href=url.parseUrl(Base.path);

      }

      function del(id) {

          $.get("del".parseUrl(Base.path),{id:id}).always(back)
      }

      function  back(data) {

          var url = "index";
          location.href = url.parseUrl(Base.path);
       
      }
      
      function addbutton(){
    	  var url = "add.html";
          location.href = url.parseUrl(Base.path);  
     }
</script>
</body>
</html>