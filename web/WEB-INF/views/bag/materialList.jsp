<%--
  Created by IntelliJ IDEA.
  User: chenfeilong
  Date: 2017/10/19
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>材料列表</title>
    <jsp:include page="../common/bootstraptablecss.jsp"></jsp:include>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>材料列表</h5>
        </div>
        <div class="ibox-content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    查询条件
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label">所属包型</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="bagTypeId" id="bagTypeId_" >
                            <option value="">全部</option>
                        </select>
                    </div>
                    <label class="col-sm-1 control-label">产品名称</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="shopName" name="shopName"/>
                    </div>
                    <label class="col-sm-1 control-label">材料规格</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="materialGuige" name="materialGuige"/>
                    </div>
                    <label class="col-sm-1 control-label">材料颜色</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="materialColor" name="materialColor"/>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label">材料单位</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="materialUnit" name="materialUnit"/>
                    </div>
                    <label class="col-sm-1 control-label">材料用量</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="materialYongliang" id="materialYongliang"/>
                    </div>
                    <label class="col-sm-1 control-label">材料耗损</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="materialHaosun" id="materialHaosun"/>
                    </div>
                    <label class="col-sm-1 control-label">材料要求</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="descriptions" name="description"/>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <div class="col-sm-3">
                        <button class="btn btn-primary col-sm-12 " id="search_btn">查询</button>
                    </div>
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <table id="mytab" name="mytab" class="table table-hover"></table>
                    <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
                        <button id="btn_delete" onclick="deleteMany();" type="button" class="btn btn-default" style="display: block;">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>批量修改状态
                        </button>
                        <button id="btn_add" type="button" class="btn btn-default" data-toggle="modal" data-target="#webAdd">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>新增
                        </button>
                        <button id="daochu" type="button" class="btn btn-default" onclick="method5(mytab)">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>导出数据
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="remark_modal" tabindex="-1" role="dialog" aria-labelledby="remark_modal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    材料说明
                </h4>
            </div>
            <div class="modal-body" id="remarks">

            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
<%--网站数据的新增--%>
<!-- 模态框（Modal） -->
<div class="modal fade" id="webAdd" tabindex="-1" role="dialog" aria-labelledby="webAddLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="webAddTitle">
                    新增材料
                </h4>
            </div>
            <form class="form-horizontal" method="post" id="formadd">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">所属包型</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="bagTypeId" id="bagTypeId" >

                            </select>
                        </div>
                        <label class="col-sm-2 control-label">产品名称</label>
                        <div class="col-sm-4">
                            <input  name="shopName" minlength="2" placeholder="产品名称" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">材料名称</label>
                        <div class="col-sm-4">
                            <input  name="materialName" minlength="2" placeholder="材料名称" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">材料规格</label>
                        <div class="col-sm-4">
                            <input  name="materialGuige" minlength="2" placeholder="材料规格" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">材料颜色</label>
                        <div class="col-sm-4">
                            <input  name="materialColor" minlength="2" placeholder="材料颜色" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">材料单位</label>
                        <div class="col-sm-4">
                            <input  name="materialUnit" minlength="2" placeholder="材料单位" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">材料用量</label>
                        <div class="col-sm-4">
                            <input  name="materialYongliang" minlength="2" placeholder="材料用量" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">材料耗损</label>
                        <div class="col-sm-4">
                            <input  name="materialHaosun" minlength="2" maxlength="20"  placeholder="材料耗损" type="text" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">材料单价</label>
                        <div class="col-sm-4">
                            <input  name="materialPrice" minlength="2" placeholder="材料单价" maxlength="20" type="number" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">材料说明</label>
                        <div class="col-sm-10">
                            <textarea  name="description" class="form-control" placeholder="材料说明" required="" aria-required="true"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="add" class="btn btn-primary" data-dismiss="modal">
                        确认新增
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<input type="hidden" value=""  id="deleteId"/>
<%--网站新增结束--%>
<div class="modal fade" id="updateStatus" tabindex="-1" role="dialog" aria-labelledby="webAddLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" >
                    批量修改状态
                </h4>
            </div>
            <form class="form-horizontal" method="post" id="update_status">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">材料状态：</label>
                        <div class="col-sm-8">
                            <select class="form-control"  id="status" required name="status">
                                <option value="0">启用</option>
                                <option value="1">停用</option>
                            </select>
                        </div>
                        <input id="statusId" type="hidden" name="manyId" />
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="updateSta" class="btn btn-primary" data-dismiss="modal">
                        确认修改
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--网站信息的修改--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    材料的修改
                </h4>
            </div>
            <form class="form-horizontal" id="updateform" >
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">所属包型</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="bagTypeId" id="bagType_Id" >

                            </select>
                        </div>
                        <label class="col-sm-2 control-label">产品名称</label>
                        <div class="col-sm-4">
                            <input  name="shopName" minlength="2" placeholder="产品名称" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">材料名称</label>
                        <div class="col-sm-4">
                            <input  name="materialName" minlength="2" placeholder="材料名称" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">材料规格</label>
                        <div class="col-sm-4">
                            <input  name="materialGuige" minlength="2" placeholder="材料规格" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">材料颜色</label>
                        <div class="col-sm-4">
                            <input  name="materialColor" minlength="2" placeholder="材料颜色" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">材料单位</label>
                        <div class="col-sm-4">
                            <input  name="materialUnit" minlength="2" placeholder="材料单位" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">材料用量</label>
                        <div class="col-sm-4">
                            <input  name="materialYongliang" minlength="2" placeholder="材料用量" maxlength="20" type="text" class="form-control" required="" aria-required="true">
                        </div>
                        <label class="col-sm-2 control-label">材料耗损</label>
                        <div class="col-sm-4">
                            <input  name="materialHaosun" minlength="2" maxlength="20"  placeholder="材料耗损" type="text" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">材料单价</label>
                        <div class="col-sm-4">
                            <input  name="materialPrice" minlength="2" placeholder="材料单价" maxlength="20" type="number" class="form-control" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">材料说明</label>
                        <div class="col-sm-10">
                            <textarea  name="description" class="form-control" placeholder="材料说明" required="" aria-required="true"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="update" class="btn btn-primary" data-dismiss="modal">
                        确认修改
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--网站信息的修改--%>
<jsp:include page="../common/bootstraptablejs.jsp"></jsp:include>
<script src="<%=path%>/static/js/pageJs/material.js"></script>
    <script src="<%=path%>/static/js/jquery.table2excel.min.js"></script>
</body>
<%--<script>--%>
    <%--$(function () {--%>
        <%--alert("asdflsfa");--%>
        <%--layer.msg('已发布', {icon:1,time:1000});--%>
        <%--layer.msg('已发布', {icon:2,time:1000});--%>
        <%--layer.msg('已发布', {icon:3,time:1000});--%>
        <%--layer.msg('已发布', {icon:4,time:1000});--%>
        <%--layer.msg('已发布', {icon:5,time:1000});--%>
        <%--layer.msg('已发布', {icon:6,time:1000});--%>
        <%--layer.msg('已发布', {icon:7,time:1000});--%>
        <%----%>
    <%--});--%>

<%--</script>--%>
<script>
    $.post(
        "/bagType/getBagType",
        function (data) {
            $("#bagTypeId").select2({
                data: data
            })
            $("#bagType_Id").select2({
                data: data
            })
            $("#bagTypeId_").select2({
                data: data
            })
            $("#select2-bagTypeId_-container").remove();
            $("#select2-bagTypeId-container").remove();
            $("#select2-bagType_Id-container").remove();
        },
        "json"
    );
</script>
</html>
