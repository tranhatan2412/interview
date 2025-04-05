# Hướng 1
-- Sử dụng HashMap với key là địa chỉ, value là đơn hàng đã được gộp
-- Không cần tốn thời gian sắp xếp dữ liệu
-- Thời gian tìm kiếm đơn hàng nhanh O(1)
-- Độ phức tạp O(n) vì chỉ cần duyệt danh sách các đơn hàng
-- Hiệu năng cao
-- Code đơn giản hơn, dễ nhìn
-- Tính mở rộng cao khi cần thêm những tiêu chí gộp khác, không cần thứ tự dữ liệu
-- Tốn bộ nhớ hơn
# Hướng 2
-- Sử dụng ArrayList, cần sắp xếp dữ liệu và cần biến tạm để theo dõi địa chỉ đơn hàng hiện tại
-- ArrayList sử dụng Merge Sort để sắp xếp dữ liệu nên độ phức tạp là O(nlogn), tốn thêm thời gian sắp xếp
-- Thời gian duyệt danh sách tuần tự O(n)
-- Hiệu năng kém hơn
-- Code phức tạp hơn
-- Tính mở rộng kém hơn, nhất là khi có lượng lớn dữ liệu cần sắp xếp, tốn thời gian tìm kiếm
-- Tốn ít bộ nhớ hơn