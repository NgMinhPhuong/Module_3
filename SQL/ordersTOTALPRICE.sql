use quanlybanhang;
update orders
join(
select oID, sum(orderdetail.odQTY*product.pPrice) sumVal
from orderdetail join product on orderdetail.pID = product.pID
group by oID) as t
on orders.oID = t.oID
set orders.oTotalPrice = t.sumVal;