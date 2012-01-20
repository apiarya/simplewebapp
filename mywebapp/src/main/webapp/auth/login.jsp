<form method="POST" action='<%= response.encodeURL("j_security_check") %>'>
<table align="center">
<c:if test='${not empty param["Retry"]}'>
 <tr>
  <td colspan='2' align='center'><b>Please try again.</b></td>
 </tr>
 <tr>
  <td>&nbsp;</td>
 </tr>
</c:if>
<tr>
 <td><label>Name</label></td>
 <td><input type="text" name="j_username"></td>
</tr>
<tr>
 <td><label>Password</label></td>
 <td><input type="password" name="j_password"></td>
</tr>
<tr align="center">
 <td colspan="2"><input type="submit" value="Login"></td>
</tr>
</table>
</form>