<html>
<body>

<?
    include "mysqlconecta.php"; // Conecta ao banco de dados
    include "mysqlexecuta.php"; // Executa a cl‡usula SQL

    //Executa a consulta
    $sql = "SELECT * FROM tb_clientes";
    $res = mysqlexecuta($id,$sql);
?>

<table width=100% cellpading=0 cellspacing=0>

<?
   //Exibe as linhas encontradas na consulta
   while ($row = mysql_fetch_array($res)) {
?> 
  <tr>
     <td><?echo $row['codigo'];?></td>
     <td><?echo $row['nome'];?></td>
     <td><?echo $row['endereco'];?></td> 
     <td><?echo $row['cidade'];?></td> 
     <td><?echo $row['estado'];?></td> 
  </tr>

<?
 }
?>
</table> 
</body>
</html>