<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->


<head>
    <title>Upload Book Details</title>
</head>
<body>
Hello ${name} !!!!
<form action="addBook" method="post" enctype="multipart/form-data">
<table>
    <tr>
        <td>Book Name: </td><td><input type="text" name="bname"/></td>
    </tr>
    <tr>
        <td>Author: </td><td><input type="text" name="bauthor"/></td>
    </tr>
    <tr>
        <td>Edition: </td><td><input type="text" name="bedition"/></td>
    </tr>
    <tr>
        <td>Type/Stream: </td>
        <td>
            <select name="btype">
                <option> Engineering</option>
                <option> Medical</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>Description:</td><td><textarea rows="10" cols="50" name="description"></textarea></td>
    </tr>
    <tr>
        <td>Preview:</td><td><input type="file" name="bfile" id="bfile"></td>
    </tr>
    <tr>
        <td>Cost:</td><td><input type="text"></td>
    </tr>
    <tr>
        <td></td><td><input type="submit" value="Submit"></td>
    </tr>
</table>
</form>



</body>
</html>