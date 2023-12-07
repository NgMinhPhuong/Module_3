use quanlybanhang;
update orders
join(
select orderdetail.oID, sum(orderdetail.odQTY*product.pPrice) as sumVal
from orderdetail join product on orderdetail.pID = product.pID
group by oID
)as t
on t.oID = orders.oID
set orders.oTotalPrice = t.sumVal;