-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3307
-- Thời gian đã tạo: Th10 29, 2024 lúc 04:04 PM
-- Phiên bản máy phục vụ: 8.0.30
-- Phiên bản PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `phanconggiangday`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `authority`
--

CREATE TABLE `authority` (
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `authority`
--

INSERT INTO `authority` (`name`, `description`) VALUES
('ROLE_ADMIN', 'Quyền admin'),
('ROLE_ASSISTANT', 'Trợ lý đào tạo'),
('ROLE_HEAD_DEPARTMENT', 'Trưởng bộ môn'),
('ROLE_SPECIALIST', 'Chuyên viên khoa'),
('ROLE_TEACHER', 'Giảng viên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bai_viet`
--

CREATE TABLE `bai_viet` (
  `id` bigint NOT NULL,
  `anh` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(2550) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ngay_tao` datetime DEFAULT NULL,
  `noi_dung` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `tieu_de` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `bai_viet`
--

INSERT INTO `bai_viet` (`id`, `anh`, `mo_ta`, `ngay_tao`, `noi_dung`, `tieu_de`, `user_id`) VALUES
(1, 'http://res.cloudinary.com/dxqh3xpza/image/upload/v1730214110/uzem3egnszexfgqe1rzp.jpg', 'Ngày 23/10/2024, tại Hà Nội, đoàn công tác của Đại học Seoul Cyber (Hàn Quốc) – SCU do PGS.TS Eun-Joo Lee, Hiệu trưởng làm trường đoàn đã đến thăm và làm việc tại ', '2024-10-29 22:03:48', '<p><strong>Ng&agrave;y 23/10/2024, tại H&agrave; Nội, đo&agrave;n c&ocirc;ng t&aacute;c của Đại học Seoul Cyber (H&agrave;n Quốc) &ndash; SCU do PGS.TS Eun-Joo Lee, Hiệu trưởng l&agrave;m trường đo&agrave;n đ&atilde; đến thăm v&agrave; l&agrave;m việc tại Học viện C&ocirc;ng nghệ Bưu ch&iacute;nh Viễn th&ocirc;ng. PGS.TS Đặng Ho&agrave;i Bắc, Gi&aacute;m đốc Học viện v&agrave; đại diện L&atilde;nh đạo c&aacute;c đơn vị, ph&ograve;ng, ban chức năng đ&atilde; đ&oacute;n tiếp đo&agrave;n.</strong></p>\n<div id=\"attachment_32164\" class=\"wp-caption alignnone\"><img class=\"wp-image-32164 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/1-17-scaled.jpg\" sizes=\"(max-width: 2560px) 100vw, 2560px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/1-17-scaled.jpg 2560w, https://ptit.edu.vn/wp-content/uploads/2024/10/1-17-300x200.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/1-17-1024x683.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/1-17-768x512.jpg 768w, https://ptit.edu.vn/wp-content/uploads/2024/10/1-17-600x400.jpg 600w, https://ptit.edu.vn/wp-content/uploads/2024/10/1-17-1536x1024.jpg 1536w, https://ptit.edu.vn/wp-content/uploads/2024/10/1-17-2048x1365.jpg 2048w\" alt=\"\" width=\"2560\" height=\"1707\" aria-describedby=\"caption-attachment-32164\">\n<p id=\"caption-attachment-32164\" class=\"wp-caption-text\">To&agrave;n cảnh buổi l&agrave;m việc</p>\n<p>&nbsp;</p>\n</div>\n<p>Tại buổi l&agrave;m việc, PGS.TS Đặng Ho&agrave;i Bắc đ&atilde; vui mừng ch&agrave;o đ&oacute;n đo&agrave;n c&ocirc;ng t&aacute;c của Đại học Đại học Seoul Cyber (H&agrave;n Quốc) đến thăm Học viện. Gi&aacute;m đốc Học viện cũng chia sẻ dự định của Học viện sẽ th&agrave;nh lập &ldquo;Trung t&acirc;m Việt &ndash;H&agrave;n&rdquo; nhằm hỗ trợ sinh vi&ecirc;n học tiếng H&agrave;n Quốc, giới thiệu văn h&oacute;a H&agrave;n Quốc, giới thiệu việc l&agrave;m v&agrave; văn h&oacute;a doanh nghiệp tại H&agrave;n Quốc&hellip;. Gi&aacute;m đốc Học viện cho biết, ph&iacute;a Học viện đ&atilde; v&agrave; đang khẩn trương ho&agrave;n tất c&aacute;c thủ tục để sớm triển khai c&aacute;c chương tr&igrave;nh đ&agrave;o tạo ph&ugrave; hợp với thị trường lao động H&agrave;n Quốc. Gi&aacute;m đốc Học viện cũng khẳng định mối quan hệ hợp t&aacute;c giữa hai trường rất tốt đẹp v&agrave; c&aacute;c chương tr&igrave;nh hợp t&aacute;c rất c&oacute; triển vọng trong tương lai.</p>\n<div id=\"attachment_32165\" class=\"wp-caption alignnone\"><img class=\"wp-image-32165 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/3-10-scaled.jpg\" sizes=\"(max-width: 2560px) 100vw, 2560px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/3-10-scaled.jpg 2560w, https://ptit.edu.vn/wp-content/uploads/2024/10/3-10-300x194.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/3-10-1024x663.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/3-10-768x497.jpg 768w, https://ptit.edu.vn/wp-content/uploads/2024/10/3-10-1536x994.jpg 1536w, https://ptit.edu.vn/wp-content/uploads/2024/10/3-10-2048x1325.jpg 2048w\" alt=\"\" width=\"2560\" height=\"1656\" aria-describedby=\"caption-attachment-32165\">\n<p id=\"caption-attachment-32165\" class=\"wp-caption-text\">PGS.TS Đặng Ho&agrave;i Bắc cho biết: Học viện sẽ th&agrave;nh lập &ldquo;Trung t&acirc;m Việt &ndash; H&agrave;n&rdquo;</p>\n</div>\n<p>PGS.TS Eun-Joo Lee, Hiệu trưởng Đại học SCU đ&atilde; cảm ơn sự đ&oacute;n tiếp trọng thị của Học viện v&agrave; khẳng định: &ldquo;hoạt động hợp t&aacute;c n&agrave;y mang &yacute; nghĩa rất lớn khi PTIT l&agrave; đối t&aacute;c đầu ti&ecirc;n của SCU về thực hiện chương tr&igrave;nh 2+2&rdquo;. PGS.TS Eun-Joo Lee nhấn mạnh, với tốc độ ph&aacute;t triển nhanh của Tr&iacute; tuệ nh&acirc;n tạo (AI), việc đẩy nhanh chương tr&igrave;nh hợp t&aacute;c li&ecirc;n kết đ&agrave;o tạo l&agrave; cần thiết để đ&aacute;p ứng nhu cầu cấp b&aacute;ch về nguồn nh&acirc;n lực trong c&aacute;c lĩnh vực c&ocirc;ng nghệ cao. SCU cho biết, hiện SCU đ&atilde; ph&aacute;t triển học liệu số phục vụ chương tr&igrave;nh v&agrave; kết hợp với c&aacute;c doanh nghiệp để tạo n&ecirc;n c&aacute;c b&agrave;i giảng về AI. V&igrave; vậy, PGS.TS Eun-Joo Lee mong muốn hai trường sẽ c&oacute; c&aacute;c hoạt động hợp t&aacute;c chặt chẽ v&agrave; to&agrave;n diện hơn để việc hỗ trợ trợ sinh vi&ecirc;n được nhiều hơn trong qu&aacute; tr&igrave;nh học tập v&agrave; t&igrave;m kiếm việc l&agrave;m tại thị trường lao động H&agrave;n Quốc.</p>\n<div id=\"attachment_32166\" class=\"wp-caption alignnone\"><img class=\"wp-image-32166 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/2-14-scaled.jpg\" sizes=\"(max-width: 2560px) 100vw, 2560px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/2-14-scaled.jpg 2560w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-14-300x233.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-14-1024x796.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-14-768x597.jpg 768w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-14-1536x1193.jpg 1536w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-14-2048x1591.jpg 2048w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-14-668x520.jpg 668w\" alt=\"\" width=\"2560\" height=\"1989\" aria-describedby=\"caption-attachment-32166\">\n<p id=\"caption-attachment-32166\" class=\"wp-caption-text\">PGS.TS Eun-Joo Lee, Hiệu trưởng Đại học SCU mong muốn hai trường nhanh ch&oacute;ng triển khai chương tr&igrave;nh li&ecirc;n kết đ&agrave;o tạo</p>\n<p>&nbsp;</p>\n</div>\n<p>Tại buổi l&agrave;m việc, PTIT cũng đ&atilde; thảo luận về tiến độ triển khai thực hiện chương tr&igrave;nh li&ecirc;n kết với SCU. Theo đ&oacute;, PTIT đ&atilde; ho&agrave;n thiện đề &aacute;n của chương tr&igrave;nh li&ecirc;n kết 2+2 ng&agrave;nh C&ocirc;ng nghệ th&ocirc;ng tin ứng dụng theo m&ocirc; h&igrave;nh đại học số, đ&atilde; b&aacute;o c&aacute;o v&agrave; gửi Bộ Gi&aacute;o dục v&agrave; Đ&agrave;o tạo. Dự kiến, chương tr&igrave;nh sẽ bắt đầu tuyển sinh từ th&aacute;ng 11 năm 2024 v&agrave; sẽ bắt đầu học từ cuối th&aacute;ng 12/2024. Hiện nay, PTIT cũng đ&atilde; ho&agrave;n thiện hệ thống đ&agrave;o tạo trực tuyến v&agrave; hạ tầng phục vụ cho chương tr&igrave;nh. PTIT cũng đề xuất ph&iacute;a SCU hỗ trợ địa điểm khai giảng, tổ chức thi c&aacute;c kh&oacute;a học&hellip;</p>\n<p>Trước đ&oacute;, th&aacute;ng 8/2024, trong chuyến c&ocirc;ng t&aacute;c tại H&agrave;n Quốc, với sự chứng kiến của Bộ trưởng Bộ Th&ocirc;ng tin v&agrave; Truyền th&ocirc;ng Nguyễn Mạnh H&ugrave;ng, Học viện C&ocirc;ng nghệ Bưu ch&iacute;nh Viễn th&ocirc;ng đ&atilde; khai trương văn ph&ograve;ng li&ecirc;n kết đ&agrave;o tạo SCU &ndash; PTIT đặt tại Đại học Seoul Cyber. Văn ph&ograve;ng n&agrave;y l&agrave; điểm kết nối, x&uacute;c tiến c&aacute;c hoạt động li&ecirc;n kết đ&agrave;o tạo ng&agrave;nh C&ocirc;ng nghệ th&ocirc;ng tin ứng dụng của PTIT theo m&ocirc; h&igrave;nh đại học số tại H&agrave;n Quốc. Mục ti&ecirc;u hướng tới l&agrave; đ&agrave;o tạo v&agrave; cung cấp nguồn nh&acirc;n lực c&oacute; tay nghề cao, đ&aacute;p ứng nhu cầu của c&aacute;c tổ chức, doanh nghiệp v&agrave; x&atilde; hội ngay sau khi tốt nghiệp, đặc biệt l&agrave; cho cả doanh nghiệp Việt Nam v&agrave; H&agrave;n Quốc.</p>', 'PTIT và SCU đẩy nhanh triển khai chương trình liên kết 2+2', 1),
(2, 'http://res.cloudinary.com/dxqh3xpza/image/upload/v1730214146/odsudxgytta71fdca03m.jpg', 'Ngày 23/10/2024, tại Hà Nội, đoàn cán bộ của Bộ Giáo dục và Đào tạo nước Cộng hòa Vanuatu đã đến thăm và làm việc tại Học viện Công nghệ Bưu chính Viễn thông', '2024-10-29 22:04:25', '<p><strong>Ng&agrave;y 23/10/2024, tại H&agrave; Nội, đo&agrave;n c&aacute;n bộ của Bộ Gi&aacute;o dục v&agrave; Đ&agrave;o tạo nước Cộng h&ograve;a Vanuatu đ&atilde; đến thăm v&agrave; l&agrave;m việc tại Học viện C&ocirc;ng nghệ Bưu ch&iacute;nh Viễn th&ocirc;ng. Đo&agrave;n c&ocirc;ng t&aacute;c c&oacute;: &ocirc;ng Trần Nam Trung, Tổng L&atilde;nh sự Cộng h&ograve;a Vanuatu tại Việt Nam; &ocirc;ng Yan AMOS, Quyền Gi&aacute;m đốc H&agrave;nh ch&iacute;nh &ndash; T&agrave;i ch&iacute;nh; &ocirc;ng Samuel KATIPA, Quyền Gi&aacute;m đốc Điều h&agrave;nh, Bộ Gi&aacute;o dục v&agrave; Đ&agrave;o tạo Cộng h&ograve;a Vanuatu. PGS.TS Đặng Ho&agrave;i Bắc- Gi&aacute;m đốc Học viện v&agrave; đại diện L&atilde;nh đạo c&aacute;c đơn vị, ph&ograve;ng, ban chức năng đ&atilde; đ&oacute;n tiếp đo&agrave;n.</strong></p>\n<div class=\"wp-caption alignnone\"><img class=\"wp-image-32134 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/1-16-scaled.jpg\" sizes=\"(max-width: 2560px) 100vw, 2560px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/1-16-scaled.jpg 2560w, https://ptit.edu.vn/wp-content/uploads/2024/10/1-16-300x187.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/1-16-1024x640.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/1-16-768x480.jpg 768w, https://ptit.edu.vn/wp-content/uploads/2024/10/1-16-1536x960.jpg 1536w, https://ptit.edu.vn/wp-content/uploads/2024/10/1-16-2048x1280.jpg 2048w\" alt=\"\" width=\"2560\" height=\"1600\">\n<p class=\"wp-caption-text\">PGS.TS Đặng Ho&agrave;i Bắc, Gi&aacute;m đốc Học viện chia sẻ: PTIT sẵn s&agrave;ng ch&agrave;o đ&oacute;n sinh vi&ecirc;n Vanuatu đến học tập v&agrave; nghi&ecirc;n cứu</p>\n</div>\n<p>Thay mặt tập thể L&atilde;nh đạo Học viện, PGS. TS Đặng Ho&agrave;i Bắc đ&atilde; vui mừng ch&agrave;o đ&oacute;n đo&agrave;n c&ocirc;ng t&aacute;c của Bộ Gi&aacute;o dục v&agrave; Đ&agrave;o tạo đến thăm Học viện. Chia sẻ th&ocirc;ng tin về Học viện,&nbsp;PGS.TS Đặng Ho&agrave;i Bắc cho biết: Học viện C&ocirc;ng nghệ Bưu ch&iacute;nh Viễn th&ocirc;ng l&agrave; trường đại học duy nhất trực thuộc Bộ Th&ocirc;ng tin v&agrave; Truyền th&ocirc;ng, c&oacute; 2 cơ sở đ&agrave;o tại ở ở 2 th&agrave;nh phố lớn nhất cả nước l&agrave; H&agrave; Nội v&agrave; Th&agrave;nh phố Hồ Ch&iacute; Minh, với hơn 20 ng&agrave;n sinh vi&ecirc;n v&agrave; gần 30 ng&agrave;nh đ&agrave;o tạo. Tại Việt Nam, Học viện l&agrave; trường ti&ecirc;n phong mở c&aacute;c ng&agrave;nh đ&agrave;o tạo An to&agrave;n th&ocirc;ng tin, C&ocirc;ng nghệ Đa phương tiện, C&ocirc;ng nghệ t&agrave;i ch&iacute;nh&hellip; Hiện nay, tại Học viện, c&oacute; nhiều sinh vi&ecirc;n quốc tế đang theo học, trong đ&oacute; c&oacute; sinh vi&ecirc;n c&aacute;c nước Asean, M&ocirc;ng Cổ&hellip; Gi&aacute;m đốc Học viện cũng khẳng định: PTIT l&agrave; trường đại học trẻ c&oacute; tốc độ tăng trưởng rất nhanh v&agrave; sẵn s&agrave;ng ch&agrave;o đ&oacute;n sinh vi&ecirc;n Vanuatu đến học tập v&agrave; nghi&ecirc;n cứu tại PTIT. PTIT c&ograve;n c&oacute; thế mạnh về kết nối với c&aacute;c h&atilde;ng c&ocirc;ng nghệ lớn n&ecirc;n sẽ hỗ trợ tốt cho c&aacute;c hoạt động đ&agrave;o tạo v&agrave; nghi&ecirc;n cứu.</p>\n<div class=\"wp-caption alignnone\"><img class=\"wp-image-32135 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/2-13-scaled.jpg\" sizes=\"(max-width: 2560px) 100vw, 2560px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/2-13-scaled.jpg 2560w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-13-300x188.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-13-1024x640.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-13-768x480.jpg 768w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-13-1536x960.jpg 1536w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-13-2048x1280.jpg 2048w\" alt=\"\" width=\"2560\" height=\"1600\">\n<p class=\"wp-caption-text\">Đại diện đo&agrave;n c&ocirc;ng t&aacute;c &ocirc;ng Yan AMOS, Quyền Gi&aacute;m đốc H&agrave;nh ch&iacute;nh &ndash; T&agrave;i ch&iacute;nh chia sẻ th&ocirc;ng tin tại buổi l&agrave;m việc</p>\n</div>\n<p>Đại diện đo&agrave;n c&ocirc;ng t&aacute;c &ocirc;ng Yan AMOS, Quyền Gi&aacute;m đốc H&agrave;nh ch&iacute;nh &ndash; T&agrave;i ch&iacute;nh chia sẻ: Vanuatu v&agrave; Việt Nam đ&atilde; c&oacute; quan hệ ngoại giao từ rất l&acirc;u v&agrave; lu&ocirc;n bền chặt. Vanuatu lu&ocirc;n mong muốn t&igrave;m kiếm cơ hội để sinh vi&ecirc;n Vanuatu c&oacute; thể học tập tại c&aacute;c quốc gia v&agrave; c&aacute;c cơ sở gi&aacute;o dục đại học uy t&iacute;n. &Ocirc;ng Yan Amos n&oacute;i: &ldquo;Ch&uacute;ng t&ocirc;i đ&atilde; chọn Việt Nam v&igrave; ch&uacute;ng t&ocirc;i kỳ vọng đất nước của c&aacute;c bạn sẽ l&agrave; một m&ocirc;i trường gi&aacute;o dục tốt cho c&ocirc;ng d&acirc;n Vanuatu. Ch&uacute;ng t&ocirc;i cũng rất cảm k&iacute;ch v&igrave; c&oacute; cơ hội được đến PTIT, một trường đại học uy t&iacute;n h&agrave;ng đầu tại Việt Nam, để trao đổi về cơ hội học tập v&agrave; nghi&ecirc;n cứu cho sinh vi&ecirc;n Vanuatu&rdquo;.</p>\n<p>Tại buổi l&agrave;m việc, đại diện L&atilde;nh đạo hai b&ecirc;n đ&atilde; tập trung thảo luận về việc gửi sinh vi&ecirc;n Vanuatu sang du học tại Việt Nam; c&aacute;c nội dugn hợp t&aacute;c sẽ tập trung v&agrave;o c&aacute;c lĩnh vực c&ocirc;ng nghệ, kỹ thuật c&ocirc;ng nghiệp, y tế, du lịch, nh&agrave; h&agrave;ng kh&aacute;ch sạn, n&ocirc;ng l&acirc;m ngư nghiệp&hellip;; Khả năng hợp t&aacute;c n&acirc;ng cao chất lượng giảng dạy tiếng Anh v&agrave; tiếng Ph&aacute;p tại c&aacute;c trường học Vanuatu v&agrave; đề xuất c&aacute;c cơ hội hợp t&aacute;c v&agrave; giao lưu gi&aacute;o dục giữa hai quốc gia.</p>\n<p><img class=\"alignnone wp-image-32136 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/5-7-scaled.jpg\" sizes=\"(max-width: 2560px) 100vw, 2560px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/5-7-scaled.jpg 2560w, https://ptit.edu.vn/wp-content/uploads/2024/10/5-7-300x188.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/5-7-1024x640.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/5-7-768x480.jpg 768w, https://ptit.edu.vn/wp-content/uploads/2024/10/5-7-1536x960.jpg 1536w, https://ptit.edu.vn/wp-content/uploads/2024/10/5-7-2048x1280.jpg 2048w\" alt=\"\" width=\"2560\" height=\"1600\"></p>\n<div class=\"wp-caption alignnone\"><img class=\"wp-image-32137 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/6-scaled.jpg\" sizes=\"(max-width: 2560px) 100vw, 2560px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/6-scaled.jpg 2560w, https://ptit.edu.vn/wp-content/uploads/2024/10/6-300x188.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/6-1024x640.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/6-768x480.jpg 768w, https://ptit.edu.vn/wp-content/uploads/2024/10/6-1536x960.jpg 1536w, https://ptit.edu.vn/wp-content/uploads/2024/10/6-2048x1280.jpg 2048w\" alt=\"\" width=\"2560\" height=\"1600\" loading=\"lazy\">\n<p class=\"wp-caption-text\">Đo&agrave;n c&ocirc;ng t&aacute;c của Bộ Gi&aacute;o dục v&agrave; Đ&agrave;o tạo nước Cộng h&ograve;a Vanuatu thăm cơ sở vật chất của Học viện</p>\n</div>\n<p>Đo&agrave;n c&ocirc;ng t&aacute;c của Bộ Gi&aacute;o dục v&agrave; Đ&agrave;o tạo nước Cộng h&ograve;a Vanuatu cũng đ&atilde; tham quan cơ sở vật chất bao gồm c&aacute;c ph&ograve;ng học, ph&ograve;ng th&iacute; nghiệm, trung t&acirc;m nghi&ecirc;n cứu, khu vực k&yacute; t&uacute;c x&aacute;, v&agrave; c&aacute;c tiện &iacute;ch kh&aacute;c để hiểu r&otilde; hơn về m&ocirc;i trường học tập v&agrave; điều kiện sinh hoạt d&agrave;nh cho sinh vi&ecirc;n tại PTIT.</p>', 'Đoàn cán bộ Bộ Giáo dục và Đào tạo nước Cộng hòa Vanuatu thăm và làm việc tại Học viện Công nghệ Bưu chính Viễn thông', 1),
(3, 'http://res.cloudinary.com/dxqh3xpza/image/upload/v1730214177/i7xs1qnmyxenjafqwck7.jpg', ' Ngày 22/10/2024, tại Hà Nội, Học viện Công nghệ Bưu chính Viễn thông (PTIT) và Công ty Cổ phần Công nghệ Bravestars đã ký biên bản ghi nhớ hợp ', '2024-10-29 22:04:55', '<p><strong>&nbsp;</strong><strong>Ng&agrave;y 22/10/2024, tại H&agrave; Nội, Học viện C&ocirc;ng nghệ Bưu ch&iacute;nh Viễn th&ocirc;ng (PTIT) v&agrave; C&ocirc;ng ty Cổ phần C&ocirc;ng nghệ Bravestars đ&atilde; k&yacute; bi&ecirc;n bản ghi nhớ hợp t&aacute;c trong việc đ&agrave;o tạo v&agrave; ph&aacute;t triển nguồn nh&acirc;n lực ng&agrave;nh c&ocirc;ng nghiệp game. Tham dự Lễ k&yacute; c&oacute;, PGS.TS Đặng Ho&agrave;i Bắc, Gi&aacute;m đốc Học viện, TS. Nguyễn Trung Ki&ecirc;n, Ph&oacute; Gi&aacute;m đốc Học viện, &ocirc;ng Ho&agrave;ng Viết Hải, Gi&aacute;m đốc Điều h&agrave;nh CTCP C&ocirc;ng nghệ Bravestars.</strong></p>\n<p>Theo Bi&ecirc;n bản ghi nhớ hợp t&aacute;c, Bravestars sẽ đồng h&agrave;nh c&ugrave;ng Học viện trong c&aacute;c hoạt động &yacute; nghĩa d&agrave;nh cho sinh vi&ecirc;n như: tiếp nhận sinh vi&ecirc;n Học viện đến tham quan, tham gia thực tập; Cử chuy&ecirc;n gia tham gia tư vấn, đ&aacute;nh gi&aacute;, x&acirc;y dựng nội dung, giảng dạy c&aacute;c chương tr&igrave;nh đ&agrave;o tạo Game của Học viện.</p>\n<div id=\"attachment_32123\" class=\"wp-caption alignnone\"><img class=\"wp-image-32123 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346850_a2d2551c320302db87286bdd893f910e.jpg\" sizes=\"(max-width: 2560px) 100vw, 2560px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346850_a2d2551c320302db87286bdd893f910e.jpg 2560w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346850_a2d2551c320302db87286bdd893f910e-300x188.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346850_a2d2551c320302db87286bdd893f910e-1024x640.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346850_a2d2551c320302db87286bdd893f910e-768x480.jpg 768w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346850_a2d2551c320302db87286bdd893f910e-1536x960.jpg 1536w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346850_a2d2551c320302db87286bdd893f910e-2048x1280.jpg 2048w\" alt=\"\" width=\"2560\" height=\"1600\" aria-describedby=\"caption-attachment-32123\">\n<p id=\"caption-attachment-32123\" class=\"wp-caption-text\">PGS. TS Đặng Ho&agrave;i Bắc, Gi&aacute;m đốc Học viện v&agrave; &ocirc;ng Ho&agrave;ng Viết Hải &ndash; Gi&aacute;m đốc điều h&agrave;nh CTCP C&ocirc;ng nghệ Bravestars trao Bi&ecirc;n bản ghi nhớ hợp t&aacute;c</p>\n<p>&nbsp;</p>\n</div>\n<p>B&ecirc;n cạnh đ&oacute;, Bravestars sẽ phối hợp với PTIT tổ chức c&aacute;c chương tr&igrave;nh hội thảo, tọa đ&agrave;m h&agrave;ng năm về c&aacute;c chủ đề li&ecirc;n quan tới lĩnh vực Game nhằm gi&uacute;p sinh vi&ecirc;n PTIT nắm bắt được thu thế ph&aacute;t triển của ng&agrave;nh v&agrave; cung cấp c&aacute;c chương tr&igrave;nh học bổng cho sinh vi&ecirc;n t&agrave;i năng. Bravestars sẽ ưu ti&ecirc;n tuyển dụng sinh vi&ecirc;n c&oacute; kết quả học tập tốt của PTIT v&agrave;o học việc v&agrave; l&agrave;m việc; ngược lại PTIT hỗ trợ đăng tải, quảng b&aacute; c&aacute;c th&ocirc;ng tin tuyển dụng của Bravestars tr&ecirc;n c&aacute;c k&ecirc;nh truyền th&ocirc;ng của Học viện; ưu ti&ecirc;n th&ocirc;ng b&aacute;o tới Bravestars đăng k&yacute; tham gia c&aacute;c hoạt động: Ng&agrave;y hội tuyển dụng, hội nghị, hội thảo trong nước v&agrave; quốc tế do PTIT tổ chức hoặc đăng cai tổ chức,&hellip;</p>\n<div id=\"attachment_32124\" class=\"wp-caption alignnone\"><img class=\"wp-image-32124 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346779_4d9e67311ec234f1baa791b74bc785d8.jpg\" sizes=\"(max-width: 2560px) 100vw, 2560px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346779_4d9e67311ec234f1baa791b74bc785d8.jpg 2560w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346779_4d9e67311ec234f1baa791b74bc785d8-300x188.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346779_4d9e67311ec234f1baa791b74bc785d8-1024x640.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346779_4d9e67311ec234f1baa791b74bc785d8-768x480.jpg 768w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346779_4d9e67311ec234f1baa791b74bc785d8-1536x960.jpg 1536w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331346779_4d9e67311ec234f1baa791b74bc785d8-2048x1280.jpg 2048w\" alt=\"\" width=\"2560\" height=\"1600\" aria-describedby=\"caption-attachment-32124\">\n<p id=\"caption-attachment-32124\" class=\"wp-caption-text\">PGS. TS Đặng Ho&agrave;i Bắc, Gi&aacute;m đốc Học viện chia sẻ về kế hoạch của PTIT trong hợp t&aacute;c với c&aacute;c doanh nghiệp Game để đỡ đầu cho c&aacute;c dự &aacute;n start- up về Game của sinh vi&ecirc;n Học viện hướng tới thị trường Phần Lan</p>\n</div>\n<p>Ph&aacute;t biểu tại Lế k&yacute; kết, PGS. TS Đặng Ho&agrave;i Bắc, Gi&aacute;m đốc Học viện nhận định: &ldquo;Học viện C&ocirc;ng nghệ Bưu ch&iacute;nh Viễn th&ocirc;ng đ&atilde; x&acirc;y dựng một chương tr&igrave;nh đ&agrave;o tạo b&agrave;i bản v&agrave; chuy&ecirc;n nghiệp với mục ti&ecirc;u cung ứng nguồn nh&acirc;n lực chất lượng cao cho ng&agrave;nh C&ocirc;ng nghiệp Game Việt Nam n&oacute;i ri&ecirc;ng &ndash; thế giới n&oacute;i chung. Để hiện thực h&oacute;a những mục ti&ecirc;u của chương tr&igrave;nh, g&oacute;p phần th&uacute;c đẩy sự ph&aacute;t triển của ng&agrave;nh C&ocirc;ng nghiệp Game Việt Nam, hướng tới vươn tầm thế giới, Học viện đặt mục ti&ecirc;u mang c&aacute;c cơ hội học tập s&aacute;t với thực tiễn, với sự giảng dạy từ c&aacute;c chuy&ecirc;n gia đến từ Doanh nghiệp, gi&uacute;p sinh vi&ecirc;n được tiếp cận với doanh nghiệp ngay từ khi ngồi tr&ecirc;n ghế nh&agrave; trường. Với sự đồng h&agrave;nh của Bravestars th&ocirc;ng qua c&aacute;c hoạt động thực tiễn như hỗ trợ cơ sở thực tập, tham gia c&aacute;c dự &aacute;n thực tế, cung cấp c&aacute;c chương tr&igrave;nh học bổng cho sinh vi&ecirc;n, đồng h&agrave;nh tổ chức c&aacute;c cuộc thi&hellip; Học viện tin rằng sinh vi&ecirc;n theo học chương tr&igrave;nh n&agrave;y sẽ l&agrave; nguồn nh&acirc;n lực n&ograve;ng cốt của Bravestars v&agrave; c&aacute;c c&ocirc;ng ty Game trong tương lai&rdquo;. Gi&aacute;m đốc Đặng Ho&agrave;i Bắc cũng chia sẻ về kế hoạch của Học viện trong hợp t&aacute;c với c&aacute;c doanh nghiệp Game để đỡ đầu cho c&aacute;c dự &aacute;n start- up về Game của sinh vi&ecirc;n Học viện hướng tới thị trường Phần Lan.</p>\n<div id=\"attachment_32125\" class=\"wp-caption alignnone\"><img class=\"wp-image-32125 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331368350_f2ad58d65c1c0db30c1595f5a165e471.jpg\" sizes=\"(max-width: 2560px) 100vw, 2560px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331368350_f2ad58d65c1c0db30c1595f5a165e471.jpg 2560w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331368350_f2ad58d65c1c0db30c1595f5a165e471-300x188.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331368350_f2ad58d65c1c0db30c1595f5a165e471-1024x640.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331368350_f2ad58d65c1c0db30c1595f5a165e471-768x480.jpg 768w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331368350_f2ad58d65c1c0db30c1595f5a165e471-1536x960.jpg 1536w, https://ptit.edu.vn/wp-content/uploads/2024/10/z5956331368350_f2ad58d65c1c0db30c1595f5a165e471-2048x1280.jpg 2048w\" alt=\"\" width=\"2560\" height=\"1600\" aria-describedby=\"caption-attachment-32125\">\n<p id=\"caption-attachment-32125\" class=\"wp-caption-text\">&Ocirc;ng Ho&agrave;ng Viết Hải &ndash; Gi&aacute;m đốc điều h&agrave;nh CTCP C&ocirc;ng nghệ Bravestars ph&aacute;t biểu tại buổi Lễ</p>\n<p>&nbsp;</p>\n</div>\n<p>Về mối quan hệ hợp t&aacute;c giữa Bravestars v&agrave; PTIT, &ocirc;ng Ho&agrave;ng Viết Hải &ndash; Gi&aacute;m đốc điều h&agrave;nh CTCP C&ocirc;ng nghệ Bravestars, chia sẻ: Bravestars l&agrave; c&ocirc;ng ty ph&aacute;t triển v&agrave; ph&aacute;t h&agrave;nh game với hơn 11 năm kinh nghiệm tr&ecirc;n thị trường trong nước v&agrave; quốc tế. Với quy m&ocirc; nh&acirc;n sự gần 120 th&agrave;nh vi&ecirc;n, Bravestars đ&atilde; v&agrave; đang li&ecirc;n tục ph&aacute;t triển c&aacute;c sản phẩm game chất lượng cao, hướng tới mục ti&ecirc;u trở th&agrave;nh c&ocirc;ng ty TOP 100 trong ng&agrave;nh c&ocirc;ng nghiệp video game&nbsp; Hiện tại, Bravestars đ&atilde; c&oacute; hơn 200 sản phẩm được ph&aacute;t h&agrave;nh v&agrave; ghi nhận hơn 1 tỷ lượt tải. Sự hợp t&aacute;c giữa Bravestars v&agrave; Học viện kh&ocirc;ng chỉ l&agrave; một cột mốc quan trọng, m&agrave; c&ograve;n l&agrave; minh chứng cho sự kết nối giữa doanh nghiệp v&agrave; nh&agrave; trường, c&ugrave;ng hướng tới mục ti&ecirc;u bồi dưỡng những thế hệ trẻ t&agrave;i năng cho ng&agrave;nh Game. &Ocirc;ng Ho&agrave;ng Viết hải cho biết: &lsquo;Th&ocirc;ng qua hoạt động hợp t&aacute;c n&agrave;y, Bravestars sẽ đồng h&agrave;nh c&ugrave;ng Học viện để mang đến những cơ hội thực tập thực tế, tạo điều kiện để ph&aacute;t triển năng lực sinh vi&ecirc;n cũng như những dự &aacute;n, s&aacute;ng kiến đổi mới c&oacute; t&iacute;nh ứng dụng thực tiễn cao&rdquo;.</p>\n<p>Nhận thức được nhu cầu cấp thiết của x&atilde; hội, PTIT đ&atilde; ch&iacute;nh thức trở th&agrave;nh đơn vị đ&agrave;o tạo đầu ti&ecirc;n mở ng&agrave;nh Thiết kế v&agrave; Ph&aacute;t triển Game tr&igrave;nh độ đại học. Năm 2024, PTIT đ&atilde; tuyển sinh th&agrave;nh c&ocirc;ng chương tr&igrave;nh n&agrave;y với điểm đầu&nbsp; v&agrave;o cao. Ngay sau khi c&ocirc;ng bố mở ng&agrave;nh, PTIT cũng đ&atilde; x&uacute;c tiến hợp t&aacute;c với c&aacute;c doanh nghiệp trong lĩnh vực Game nhằm th&uacute;c đẩy c&aacute;c hoạt động hợp t&aacute;c, đ&agrave;o tạo v&agrave; ph&aacute;t triển nguồn nh&acirc;n lực chất lượng cao trong lĩnh vực Game.</p>', 'PTIT và Công ty Cổ phần Công nghệ Bravestars hợp tác phát triển nhân lực ngành Game', 1),
(4, 'http://res.cloudinary.com/dxqh3xpza/image/upload/v1730214208/ni3pyxtsxqw2dj9wxq5k.jpg', 'Ngày 19/10/2024, tại Hà Nội và Thành phố Hồ Chí Minh, đã diễn ra Vòng chung khảo cuộc thi “Sinh viên với An toàn thông tin ASEAN 2024”,', '2024-10-29 22:05:26', '<p><strong>Ng&agrave;y 19/10/2024, tại H&agrave; Nội v&agrave; Th&agrave;nh phố Hồ Ch&iacute; Minh, đ&atilde; diễn ra V&ograve;ng chung khảo cuộc thi &ldquo;Sinh vi&ecirc;n với An to&agrave;n th&ocirc;ng tin ASEAN 2024&rdquo;,&nbsp;</strong><strong>&nbsp;với sự tham gia của 83 đội, trong đ&oacute; c&oacute; 56 đội sinh vi&ecirc;n Việt Nam v&agrave; 27 đội sinh vi&ecirc;n 9 nước ASEAN kh&aacute;c. 4 đội thi của sinh vi&ecirc;n Học viện C&ocirc;ng nghệ Bưu ch&iacute;nh Viễn th&ocirc;ng đ&atilde; gi&agrave;nh 02 giải Ba v&agrave; 02 giải Khuyến kh&iacute;ch.</strong></p>\n<p>Cụ thể, Đội PTIT.Celebi v&agrave; Đội PTIT.MuSt4ngPanDa của Cơ sở Đ&agrave;o tạo H&agrave; Nội đ&atilde; lần lượt gi&agrave;nh 02 Giải Ba tại Bảng A: Tấn c&ocirc;ng &ndash; Ph&ograve;ng thủ v&agrave; Bảng B: Cướp cờ (CTF). Đội PTITHCM_L4st04nce v&agrave;&nbsp;<a href=\"https://ascis.vn/teams/915\">PTITHCM_Invisible</a>&nbsp;của Học viện Cơ sở tại TPHCM đ&atilde; đạt 02 giải khuyến kh&iacute;ch tại bảng A v&agrave; B của cuộc thi.</p>\n<p><img class=\"wp-image-32107 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/4-7.jpg\" sizes=\"(max-width: 1280px) 100vw, 1280px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/4-7.jpg 1280w, https://ptit.edu.vn/wp-content/uploads/2024/10/4-7-300x222.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/4-7-1024x758.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/4-7-768x569.jpg 768w\" alt=\"\" width=\"1280\" height=\"948\"></p>\n<div id=\"attachment_32111\" class=\"wp-caption alignnone\"><img class=\"wp-image-32111 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/5-6.jpg\" sizes=\"(max-width: 1252px) 100vw, 1252px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/5-6.jpg 1252w, https://ptit.edu.vn/wp-content/uploads/2024/10/5-6-300x193.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/5-6-1024x659.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/5-6-768x494.jpg 768w\" alt=\"\" width=\"1252\" height=\"806\" aria-describedby=\"caption-attachment-32111\">\n<p id=\"caption-attachment-32111\" class=\"wp-caption-text\">Ban Tổ chức trao giải Ba cho c&aacute;c đội thi</p>\n</div>\n<p>&nbsp;</p>\n<p>C&oacute; c&ugrave;ng thời gian thi từ 8h30 đến 16h30 ng&agrave;y 19/10, song 2 bảng c&oacute; nội dung thi kh&aacute;c nhau. Cụ thể. Bảng A, thi theo dạng tấn c&ocirc;ng &ndash; ph&ograve;ng thủ trực tiếp (attack-defense), gồm 20 đội thuộc nh&oacute;m c&aacute;c đội đạt kết quả cao nhất v&ograve;ng Sơ khảo của 20 Trường (mỗi Trường chọn 01 đội điểm cao nhất). C&aacute;c đội thi cố gắng bảo vệ c&aacute;c hệ thống của m&igrave;nh khỏi c&aacute;c cuộc tấn c&ocirc;ng từ c&aacute;c đội kh&aacute;c đồng thời cố gắng tấn c&ocirc;ng v&agrave; kiếm điểm từ c&aacute;c hệ thống của đối thủ. Kết quả, Ban Tổ chức đ&atilde; trao 15 Giải thưởng gồm: 1 giải Nhất, 2 giải Nh&igrave;, 3 giải Ba, 09 giải Khuyến kh&iacute;ch.</p>\n<p>Ở bảng B, thi theo h&igrave;nh thức jeopardy, gồm 63 đội trong nh&oacute;m đạt điểm cao v&ograve;ng Sơ khảo c&ograve;n lại. Mỗi trường tham gia Cuộc thi đều c&oacute; 01 đội tham dự Bảng B v&ograve;ng Chung khảo. C&aacute;c đội phải giải quyết c&aacute;c thử th&aacute;ch về ATTT để t&igrave;m ra c&aacute;c &ldquo;cờ&rdquo; (flags) ẩn trong c&aacute;c m&aacute;y chủ, ứng dụng, hoặc c&aacute;c t&agrave;i nguy&ecirc;n mạng kh&aacute;c. Khi t&igrave;m thấy flag, c&aacute;c đội gửi flag l&ecirc;n hệ thống của BTC để ghi điểm.&nbsp;<em>C</em>&oacute; 5 nh&oacute;m thử th&aacute;ch l&agrave;: Dịch ngược, Khai th&aacute;c lỗ hổng phần mềm, Khai th&aacute;c lỗ hổng ứng dụng web, Mật m&atilde; v&agrave; m&atilde; ho&aacute;, C&aacute;c loại kh&aacute;c (điều tra số, lập tr&igrave;nh, kỹthuật giấu tin&hellip;). Kết quả, Ban Tổ chức đ&atilde; trao 24 Giải thưởng: gồm 1 giải Nhất, 3 giải Nh&igrave;, 5 giải Ba, 15 giải Khuyến kh&iacute;ch.</p>\n<div id=\"attachment_32108\" class=\"wp-caption alignnone\"><img class=\"wp-image-32108 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/2-12.jpg\" sizes=\"(max-width: 2400px) 100vw, 2400px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/2-12.jpg 2400w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-12-300x200.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-12-1024x683.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-12-768x512.jpg 768w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-12-600x400.jpg 600w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-12-1536x1024.jpg 1536w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-12-2048x1365.jpg 2048w\" alt=\"\" width=\"2400\" height=\"1600\" aria-describedby=\"caption-attachment-32108\">\n<p id=\"caption-attachment-32108\" class=\"wp-caption-text\">&Ocirc;ng Nguyễn Th&agrave;nh Hưng, Chủ tịch Hiệphội An to&agrave;n th&ocirc;ng tin Việt Nam, ph&aacute;t biểu tại lễ tổng kết v&agrave; trao giải cuộc thi</p>\n</div>\n<p>Ph&aacute;t biểu tại lễ tổng kết v&agrave; trao giải cho c&aacute;c đội thi tại H&agrave; Nội, nguy&ecirc;n Thứ trưởng Bộ TT&amp;TT Nguyễn Th&agrave;nh Hưng, Chủ tịch VNISA, khẳng định g&oacute;p phần ph&aacute;t triển nguồn nh&acirc;n lực an to&agrave;n th&ocirc;ng tin tại Việt Nam l&agrave; một định hướng quan trọng của Hiệp hội, v&agrave; cuộc thi &lsquo;Sinh vi&ecirc;n với an to&agrave;n th&ocirc;ng tin ASEAN&rsquo; h&agrave;ng năm l&agrave; hoạt động cụ thể h&oacute;a định hướng n&agrave;y. &Ocirc;ng Nguyễn Th&agrave;nh Hưng cũng khẳng định: &ldquo;Cuộc thi ng&agrave;y c&agrave;ng được n&acirc;ng cao về chất lượng, tương đồng về với c&aacute;c cuộc thi về an to&agrave;n th&ocirc;ng tin trong khu vực. C&aacute;c đội đạt giải cao tại cuộc thi của ch&uacute;ng ta đ&atilde; được cử tham gia c&aacute;c cuộc thi An to&agrave;n th&ocirc;ng tin trong khu vực v&agrave; đều đạt giải cao.</p>\n<p>C&oacute; 83 đội tham dự v&ograve;ng chung khảo &lsquo;Sinh vi&ecirc;n với An to&agrave;n th&ocirc;ng tin ASEAN 2024&rsquo;. Đ&acirc;y l&agrave; năm nay thứ 2 cuộc thi c&oacute; sự tham dự của sinh vi&ecirc;n cả 10 nước ASEAN.</p>\n<p>Được biết, Lễ trao Bằng khen của Bộ trưởng Bộ Giáo dục &amp; Đào tạo cho c&aacute;c đội đạt giải cao thuộc Bảng A sẽ được thực hiện trong Chương tr&igrave;nh Hội thảo quốc tế &ldquo;Ng&agrave;y An to&agrave;n th&ocirc;ng tin Việt Nam 2024&rdquo;, dự kiến tổ chức v&agrave;o cuối th&aacute;ng 11/2024.</p>', 'Sinh viên PTIT đạt thành tích cao tại cuộc thi ‘Sinh viên với An toàn thông tin ASEAN 2024’', 1),
(5, 'http://res.cloudinary.com/dxqh3xpza/image/upload/v1730214235/u555jppua7qxx54fmmhc.jpg', 'Vừa qua, tại Hà Nội, Khoa Tài chính Kế toán 1 – Học viện Công nghệ Bưu chính Viễn thông đã tổ chức Lễ ký Biên bản thỏa thuận hợp tác với Công ty Cổ phần Misa về hợp tác trong đào tạo, phát triển nguồn ', '2024-10-29 22:05:53', '<p><strong>Vừa qua, tại H&agrave; Nội, Khoa T&agrave;i ch&iacute;nh Kế to&aacute;n 1 &ndash; Học viện C&ocirc;ng nghệ Bưu ch&iacute;nh Viễn th&ocirc;ng đ&atilde; tổ chức Lễ k&yacute; Bi&ecirc;n bản thỏa thuận hợp t&aacute;c với C&ocirc;ng ty Cổ phần Misa về hợp t&aacute;c trong đ&agrave;o tạo, ph&aacute;t triển nguồn nh&acirc;n lực lĩnh vực t&agrave;i ch&iacute;nh&nbsp; kế to&aacute;n.</strong></p>\n<p><strong>Tham dự buổi Lễ c&oacute;, TS. Nguyễn Trung Ki&ecirc;n, Ph&oacute; Gi&aacute;m đốc Học viện, PGS.TS Đặng Thị Việt Đức, Trưởng khoa T&agrave;i ch&iacute;nh Kế to&aacute;n 1, b</strong><strong>&agrave; H&agrave; Thanh Lụa &ndash; Gi&aacute;m đốc văn ph&ograve;ng MISA tại H&agrave; Nội&nbsp;</strong><strong>v&agrave; đại diện L&atilde;nh đạo c&aacute;c đơn vị v&agrave; đ&ocirc;ng đảo sinh vi&ecirc;n khoa T&agrave;i ch&iacute;nh Kế to&aacute;n 1.</strong></p>\n<div class=\"wp-caption alignnone\"><img class=\"wp-image-32083 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/2-11.jpg\" sizes=\"(max-width: 1408px) 100vw, 1408px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/2-11.jpg 1408w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-11-300x203.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-11-1024x693.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-11-768x520.jpg 768w\" alt=\"\" width=\"1408\" height=\"953\">\n<p class=\"wp-caption-text\">PGS.TS Đặng Thị Việt Đức &ndash; Trưởng khoa T&agrave;i ch&iacute;nh Kế to&aacute;n 1, b&agrave; H&agrave; Thanh Lụa &ndash; Gi&aacute;m đốc văn ph&ograve;ng MISA tại H&agrave; Nội trao Bi&ecirc;n bản thỏa thuận hợp t&aacute;c</p>\n</div>\n<p>&nbsp;</p>\n<p>Theo thỏa thuận k&yacute; kết, PTIT v&agrave; Misa sẽ phối hợp tổ chức c&aacute;c kh&oacute;a đ&agrave;o tạo, chương tr&igrave;nh lan tỏa kiến thức, kỹ năng thực tế d&agrave;nh cho sinh vi&ecirc;n. Cụ thể: Misa hợp t&aacute;c, hỗ trợ li&ecirc;n quan đến hoạt động giảng dạy v&agrave; c&aacute;c hoạt động nghi&ecirc;n cứu khoa học của sinh vi&ecirc;n về chuy&ecirc;n m&ocirc;n t&agrave;i ch&iacute;nh &ndash; đầu tư như: t&agrave;i liệu, gi&aacute;o cụ học tập, giảng vi&ecirc;n chuy&ecirc;n gia, m&ocirc; h&igrave;nh. Misa bảo trợ chuy&ecirc;n m&ocirc;n cho hoạt động của CLB sinh vi&ecirc;n trong tổ chức c&aacute;c sự kiện khoa học v&agrave; tham gia c&aacute;c cuộc thi chuy&ecirc;n m&ocirc;n trong v&agrave; ngo&agrave;i nước, v.v&hellip;</p>\n<p>B&ecirc;n cạnh đ&oacute;, PTIT v&agrave; Misa sẽ hợp t&aacute;c trong c&aacute;c hoạt động hướng nghiệp v&agrave; tuyển dụng th&ocirc;ng qua việc&nbsp; Misa hỗ trợ trong việc định hướng nghề nghiệp, đưa kiến thức, nghiệp vụ thực tế v&agrave;o giảng dạy th&ocirc;ng qua việc cử chuy&ecirc;n gia, c&aacute;n bộ quản l&yacute; tới tư vấn, đ&agrave;o tạo, chia sẻ kinh nghiệm thực tế. H&agrave;ng năm, hai b&ecirc;n c&ugrave;ng trao đổi để triển khai c&aacute;c chương tr&igrave;nh thực tập v&agrave; tiếp nhận sinh vi&ecirc;n thực tập.</p>\n<p>PTIT v&agrave; Misa sẽ hợp t&aacute;c trong lĩnh vực nghi&ecirc;n cứu khoa học v&agrave; đ&agrave;o tạo nh&acirc;n lực th&ocirc;ng qua thực hiện c&aacute;c c&ocirc;ng tr&igrave;nh nghi&ecirc;n cứu khoa học, trong đ&oacute; ch&uacute; trọng thực hiện c&aacute;c nghi&ecirc;n cứu, đ&aacute;nh gi&aacute; một số vấn đề trọng điểm theo đề xuất của Misa. Misa tạo điều kiện để c&aacute;n bộ giảng vi&ecirc;n của PTIT tham gia c&aacute;c hoạt động nghi&ecirc;n cứu, tư vấn thực tế d&agrave;nh cho doanh nghiệp v&agrave; c&aacute;c chương tr&igrave;nh nghi&ecirc;n cứu ph&aacute;t triển sản phẩm dịch vụ mới của Misa, tạo điều kiện khảo s&aacute;t, thu thập th&ocirc;ng tin hoạt động thực tiễn tại c&aacute;c đơn vị do Misa giới thiệu.</p>\n<div class=\"wp-caption alignnone\"><img class=\"wp-image-32084 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/3-8.jpg\" sizes=\"(max-width: 1430px) 100vw, 1430px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/3-8.jpg 1430w, https://ptit.edu.vn/wp-content/uploads/2024/10/3-8-300x200.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/3-8-1024x682.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/3-8-768x512.jpg 768w, https://ptit.edu.vn/wp-content/uploads/2024/10/3-8-600x400.jpg 600w\" alt=\"\" width=\"1430\" height=\"953\">\n<p class=\"wp-caption-text\">TS. Nguyễn Trung Ki&ecirc;n, Ph&oacute; Gi&aacute;m đốc Học viện ph&aacute;t biểu tại buổi Lễ</p>\n</div>\n<p>&nbsp;</p>\n<p>Ph&aacute;t biểu tại buổi lễ k&yacute; kết, TS. Nguyễn Trung Ki&ecirc;n, Ph&oacute; Gi&aacute;m đốc Học viện khẳng định: Hợp t&aacute;c với C&ocirc;ng ty Cổ phần Misa l&agrave; một bước tiến quan trọng đ&aacute;nh dấu sự hợp t&aacute;c chặt chẽ giữa trường đại học v&agrave; doanh nghiệp, g&oacute;p phần th&uacute;c đẩy ứng dụng c&ocirc;ng nghệ th&ocirc;ng tin, tr&iacute; tuệ nh&acirc;n tạo trong llĩnh vực T&agrave;i ch&iacute;nh, Kế to&aacute;n. Đặc biệt l&agrave; g&oacute;p phần v&agrave;o hoạt động đ&agrave;o tạo nguồn nh&acirc;n lực chất lượng cao đ&aacute;p ứng nhu cầu x&atilde; hội của Học viện.</p>\n<p>B&agrave; H&agrave; Thanh Lụa &ndash; Gi&aacute;m đốc văn ph&ograve;ng MISA tại H&agrave; Nội cho biết: Misa đ&atilde; c&oacute; sự hợp t&aacute;c với khoa T&agrave;i ch&iacute;nh Kế to&aacute;n 1 của Học viện nhiều năm qua trong việc cung cấp giải ph&aacute;p phần mềm v&agrave; m&ocirc;n học cho sinh vi&ecirc;n gi&uacute;p sinh vi&ecirc;n n&acirc;ng cao việc ứng dụng c&aacute;c nền tảng c&ocirc;ng nghệ cho c&ocirc;ng việc sau khi ra trường. Việc k&yacute; bi&ecirc;n bản thỏa thuận hợp t&aacute;c n&agrave;y kh&ocirc;ng chỉ mở ra cơ hội hợp t&aacute;c mới m&agrave; c&ograve;n thể hiện sự cam kết mạnh mẽ của cả hai đơn vị trong đ&agrave;o tạo ph&aacute;t triển nguồn nh&acirc;n lực ng&agrave;nh T&agrave;i ch&iacute;nh kế to&aacute;n.</p>\n<p>Tại buổi Lễ, PGS.TS Đặng Thị Việt Đức, Trưởng khoa T&agrave;i ch&iacute;nh Kế to&aacute;n 1, đơn vị sẽ chủ tr&igrave; c&aacute;c hoạt động hợp t&aacute;c với Misa đ&atilde; cảm ơn&nbsp; sự hỗ trợ từ Misa trong c&ocirc;ng t&aacute;c đ&agrave;o tạo thời gian qua v&agrave; b&agrave;y tỏ kỳ vọng sẽ hai đơn vị tiếp tục c&oacute; những hoạt động cụ thể, thiết thực, mang lại nhiều lợi &iacute;ch cho sinh vi&ecirc;n.</p>\n<p>Misa l&agrave; một trong những c&ocirc;ng ty phần mềm h&agrave;ng đầu tại Việt Nam, chuy&ecirc;n cung cấp c&aacute;c giải ph&aacute;p phần mềm v&agrave; dịch vụ chuyển đổi số to&agrave;n diện cho c&aacute;c kh&aacute;ch h&agrave;ng doanh nghiệp, nh&agrave; nước v&agrave; c&aacute; nh&acirc;n. Hiện nay, một số phần mềm thực h&agrave;nh kế to&aacute;n của Misa đ&atilde; v&agrave; đang được sử dụng trong giảng dạy c&aacute;c m&ocirc;n học thuộc chương tr&igrave;nh đ&agrave;o tạo ng&agrave;nh Kế to&aacute;n của khoa T&agrave;i ch&iacute;nh Kế to&aacute;n 1 của Học viện. Cũng trong khu&ocirc;n khổ buổi lễ, Misa đ&atilde; trao g&oacute;i t&agrave;i trợ cho Khoa T&agrave;i ch&iacute;nh Kế to&aacute;n 1 giấy ph&eacute;p sử dụng đ&agrave;o tạo phần mềm quản l&yacute; doanh nghiệp Misa Amis v&agrave; phần mềm h&oacute;a đơn điện tử Misa meinvoice<strong>.&nbsp;</strong>Đ&acirc;y l&agrave; 2 trong số những phần mềm được sử dụng phổ biến nhất của Misa tại c&aacute;c doanh nghiệp v&agrave; hộ kinh doanh.</p>', 'PTIT và Công ty Cổ phần Misa hợp tác trong đào tạo và phát triển nguồn nhân lực tài chính – kế toán', 1),
(6, 'http://res.cloudinary.com/dxqh3xpza/image/upload/v1730214266/tp2mxj7klefohev97gwt.jpg', 'Vừa qua, Trung tâm Nghiên cứu và Phát triển Samsung Việt Nam (SRV) đã tổ chức Lễ trao học bổng sinh viên tài năng Samsung STP', '2024-10-29 22:06:24', '<div class=\"post-content\">\n<p><strong>Vừa qua, Trung t&acirc;m Nghi&ecirc;n cứu v&agrave; Ph&aacute;t triển Samsung Việt Nam (SRV) đ&atilde; tổ chức Lễ trao học bổng sinh vi&ecirc;n t&agrave;i năng Samsung STP d&agrave;nh cho sinh vi&ecirc;n c&aacute;c trường Đại học tại Việt Nam. Học viện C&ocirc;ng nghệ Bưu ch&iacute;nh Viễn th&ocirc;ng l&agrave; trường c&oacute; nhiều sinh vi&ecirc;n đạt học bổng STP nhất trong đợt trao n&agrave;y với 13 sinh vi&ecirc;n.</strong></p>\n<p>Trong 13 sinh vi&ecirc;n nhận được học bổng T&agrave;i năng Samsung STP 2024 c&oacute; 12 sinh vi&ecirc;n ng&agrave;nh C&ocirc;ng nghệ th&ocirc;ng tin v&agrave; 01 sinh vi&ecirc;n ng&agrave;nh C&ocirc;ng nghệ Đa phương tiện.</p>\n<p><img class=\"wp-image-32075 size-full aligncenter\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/463370007_858740613089953_3026087025334742701_n.jpg\" sizes=\"(max-width: 879px) 100vw, 879px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/463370007_858740613089953_3026087025334742701_n.jpg 879w, https://ptit.edu.vn/wp-content/uploads/2024/10/463370007_858740613089953_3026087025334742701_n-300x250.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/463370007_858740613089953_3026087025334742701_n-768x640.jpg 768w\" alt=\"\" width=\"879\" height=\"733\"></p>\n<p>Sinh vi&ecirc;n PTIT gi&agrave;nh được học bổng T&agrave;i năng STP năm 2024 sẽ được Samsung Việt Nam t&agrave;i trợ học bổng trị gi&aacute; 3000 USD. C&ugrave;ng với đ&oacute;, sinh vi&ecirc;n sẽ c&oacute; cơ hội được đ&agrave;o tạo chuy&ecirc;n s&acirc;u, thực tập nghề nghiệp với c&aacute;c đề t&agrave;i c&ocirc;ng nghệ mới, dưới sự hướng dẫn của c&aacute;c Kỹ sư gi&agrave;u kinh nghiệm tại SRV. Đồng thời, sinh vi&ecirc;n sẽ được đ&agrave;o tạo c&aacute;c kỹ năng về lập tr&igrave;nh, về thuật to&aacute;n chuy&ecirc;n s&acirc;u, củng cố kiến thức chuy&ecirc;n m&ocirc;n vững chắc trước khi tốt nghiệp.</p>\n<p>C&aacute;c sinh vi&ecirc;n đạt học bổng STP đều đ&atilde; ho&agrave;n th&agrave;nh c&aacute;c kh&oacute;a học Thuật to&aacute;n ứng dụng do Khoa C&ocirc;ng nghệ th&ocirc;ng tin 1 phối hợp với Samsung SRV phối hợp tổ chức với kết quả xuất sắc.</p>\n<div class=\"wp-caption aligncenter\"><img class=\"wp-image-32076 size-full\" src=\"https://ptit.edu.vn/wp-content/uploads/2024/10/2-10-scaled.jpg\" sizes=\"(max-width: 2560px) 100vw, 2560px\" srcset=\"https://ptit.edu.vn/wp-content/uploads/2024/10/2-10-scaled.jpg 2560w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-10-300x196.jpg 300w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-10-1024x670.jpg 1024w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-10-768x503.jpg 768w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-10-1536x1006.jpg 1536w, https://ptit.edu.vn/wp-content/uploads/2024/10/2-10-2048x1341.jpg 2048w\" alt=\"\" width=\"2560\" height=\"1676\">\n<p class=\"wp-caption-text\">Đại diện L&atilde;nh đạo c&aacute;c Khoa, ph&ograve;ng, ban chức năng v&agrave; c&aacute;c sinh vi&ecirc;n PTIT nhận học bổng T&agrave;i năng Samsung STP 2024</p>\n</div>\n<p>&nbsp;</p>\n</div>\n<p>Học viện C&ocirc;ng nghệ Bưu ch&iacute;nh Viễn th&ocirc;ng l&agrave; một trong c&aacute;c trường đại học, Học viện thuộc khu vực ph&iacute;a Bắc được thụ hưởng chương tr&igrave;nh học bổng &ldquo;T&agrave;i năng Samsung&rdquo; &ndash; STP 2024. Đến nay, đ&atilde; c&oacute; gần 150 sinh vi&ecirc;n PTIT được nhận học bổng n&agrave;y.</p>\n<p>Chương tr&igrave;nh học bổng STP 2024 l&agrave; một nội dung trong Bi&ecirc;n bản hợp t&aacute;c to&agrave;n diện giữa Học viện C&ocirc;ng nghệ Bưu ch&iacute;nh Viễn th&ocirc;ng v&agrave; Samsung Electronic Việt Nam cho giai đoạn 2023 &ndash; 2025. Theo bi&ecirc;n bản hợp t&aacute;c được k&yacute; kết ng&agrave;y 08/12/2022, b&ecirc;n cạnh việc hai đơn vị thống nhất sẽ tiếp tục triển khai l&agrave; chương tr&igrave;nh học bổng STP, PTIT v&agrave; Samsung sẽ triển khai c&aacute;c dự &aacute;n hợp t&aacute;c nghi&ecirc;n cứu về c&ocirc;ng nghệ di động, c&aacute;c kh&oacute;a học đ&agrave;o tạo ngắn&nbsp; hạn về Thuật to&aacute;n ứng dụng v&agrave; c&aacute;c kh&oacute;a đ&agrave;o tạo ngắn kh&aacute;c về IoT, Big Data, Security, Embedded System&hellip; gi&agrave;nh cho sinh vi&ecirc;n PTIT.</p>', '13 sinh viên PTIT nhận học bổng tài năng Samsung STP', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bo_mon`
--

CREATE TABLE `bo_mon` (
  `id` bigint NOT NULL,
  `ten_bo_mon` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `bo_mon`
--

INSERT INTO `bo_mon` (`id`, `ten_bo_mon`) VALUES
(1, 'Bộ môn Công nghệ Phần mềm'),
(2, 'Bộ môn Hệ thống Thông tin'),
(3, 'Bộ môn Khoa học Máy tính');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_hoc`
--

CREATE TABLE `chi_tiet_hoc` (
  `id` bigint NOT NULL,
  `hoc_ky_id` bigint DEFAULT NULL,
  `hoc_phan_id` bigint DEFAULT NULL,
  `ke_hoach_hoc_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giang_vien`
--

CREATE TABLE `giang_vien` (
  `id` bigint NOT NULL,
  `chuc_danh` varchar(255) DEFAULT NULL,
  `dang_hop_dong` varchar(255) DEFAULT NULL,
  `dien_thoai` varchar(255) DEFAULT NULL,
  `don_vi_cong_tac` varchar(255) DEFAULT NULL,
  `hoc_vi` varchar(255) DEFAULT NULL,
  `macb` varchar(255) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `tengv` varchar(255) DEFAULT NULL,
  `bo_mon_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `giang_vien`
--

INSERT INTO `giang_vien` (`id`, `chuc_danh`, `dang_hop_dong`, `dien_thoai`, `don_vi_cong_tac`, `hoc_vi`, `macb`, `ngay_sinh`, `tengv`, `bo_mon_id`, `user_id`) VALUES
(1, 'GV', 'Mời giảng', '0', 'Khoa điện tử viễn thông', 'TS', '11111', '2000-01-01', 'Bùi Công Giao', NULL, NULL),
(2, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'ThS', '11112', '2000-01-01', 'Bùi Đình Thắng', NULL, NULL),
(3, 'GV', 'Thỉnh giảng', '0', 'Trường Đại học Khoa học tự nhiên', 'TS', '11113', '2000-01-01', 'Bùi Tiến Lên', NULL, NULL),
(4, 'GV', 'Mời giảng', '0', 'Khoa nghệ thuật', 'ThS', '11114', '2000-01-01', 'Cao Minh Hồng Hạnh', NULL, NULL),
(5, 'GV', 'Mời giảng', '0', 'P. Đào tạo', 'ThS', '11115', '2000-01-01', 'Cao Minh Thành', NULL, NULL),
(6, 'GVC', 'Mời giảng', '0', 'P. Tổ chức cán bộ', 'TS', '11116', '2000-01-01', 'Cao Thái Phương Thanh', NULL, NULL),
(7, 'GVC', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'TS', '11117', '2000-01-01', 'Chế Thị Kim Phụng', NULL, NULL),
(8, 'GV', 'Mời giảng', '0', 'Phòng Khảo thí & đảm bảo chất lượng giáo dục', 'ThS', '11118', '2000-01-01', 'Cổ Tồn Minh Đăng', NULL, NULL),
(9, NULL, 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11119', '2000-01-01', 'Đặng Thị Kim Giao', NULL, NULL),
(10, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'TS', '11120', '2000-01-01', 'Đinh Thị Ngọc Loan', NULL, NULL),
(11, 'GVC', 'Cơ hữu', '0', 'Khoa CNTT', 'TS', '11121', '2000-01-01', 'Đinh Thị Thu Hương', NULL, NULL),
(12, 'GV', 'Mời giảng', '0', 'P. Đào tạo SĐH', 'TS', '11122', '2000-01-01', 'Đỗ Đình Thái', NULL, NULL),
(13, 'GV', 'Cơ hữu', '0', 'Đại học Văn Hiến', 'ThS', '11123', '2000-01-01', 'Đỗ Đình Trang', NULL, NULL),
(14, 'GVC', 'Thỉnh giảng', '0', 'Đại học KHTN', 'ThS', '11124', '2000-01-01', 'Đỗ Hoàng Cường', NULL, NULL),
(15, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11125', '2000-01-01', 'Đỗ Ngọc Như Loan', NULL, NULL),
(16, '', '', '0', '', 'TS', '11126', '2000-01-01', 'Đỗ Như Tài', NULL, NULL),
(17, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'ThS', '11127', '2000-01-01', 'Đỗ Thị Diên', NULL, NULL),
(18, NULL, 'Mời giảng', '0', 'Khoa GDTC', '', '11128', '2000-01-01', 'Đỗ Thụy Hội Uyên', NULL, NULL),
(19, NULL, 'Thỉnh giảng', '0', '', '', '11129', '2000-01-01', 'Đỗ Văn Nhơn', NULL, NULL),
(20, 'GV', 'Mời giảng', '0', 'Khoa nghệ thuật', 'ThS', '11130', '2000-01-01', 'Đỗ Xuân Tịnh', NULL, NULL),
(21, 'GV', 'Thỉnh giảng', '0', 'Đại học công nghệ TP. HCM', 'ThS', '11131', '2000-01-01', 'Đoàn Khải Hiếu', NULL, NULL),
(22, NULL, '', '0', 'Kompa Technology', 'ThS', '11132', '2000-01-01', 'Đồng Đăng Khoa', NULL, NULL),
(23, NULL, 'Mời giảng', '0', 'Khoa NN', '', '11133', '2000-01-01', 'Hà Ngọc Thúy', NULL, NULL),
(24, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11134', '2000-01-01', 'Hà Thanh Dũng', NULL, NULL),
(25, NULL, '', '0', 'Đại học công nghệ TP HCM', 'ThS', '11135', '2000-01-01', 'Hồ Đắc Quán', NULL, NULL),
(26, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'ThS', '11136', '2000-01-01', 'Hồ Hoàng Yến', NULL, NULL),
(27, 'GV', 'Mời giảng', '0', 'TT Ngoại Ngữ', 'ThS', '11137', '2000-01-01', 'Hồ Văn Bình', NULL, NULL),
(28, 'GV', 'Thỉnh giảng', '0', 'Công ty cổ phần công nghệ SVTEK', 'ThS', '11138', '2000-01-01', 'Hoàng Công Trình', NULL, NULL),
(29, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'ThS', '11139', '2000-01-01', 'Hoàng Đức Thắng', NULL, NULL),
(30, 'GV', 'Thỉnh giảng', '0', 'Đại học Văn Lang', 'TS', '11140', '2000-01-01', 'Hoàng Lê Minh', NULL, NULL),
(31, 'GV', 'Mời giảng', '0', 'P. Đào tạo', 'ThS', '11141', '2000-01-01', 'Hoàng Mạnh Hà', NULL, NULL),
(32, NULL, 'Mời giảng', '0', 'Khoa GDTC', '', '11142', '2000-01-01', 'Hoàng Thị Việt Anh', NULL, NULL),
(33, NULL, '', '0', 'Đại học Công nghệ thông tin', 'ThS', '11143', '2000-01-01', 'Huỳnh Hồ Thị Mộng Trinh', NULL, NULL),
(34, 'GV', 'Thỉnh giảng', '0', 'Khoa điện tử viễn thông', 'TS', '11144', '2000-01-01', 'Huỳnh Lê Minh Thiện', NULL, NULL),
(35, 'GVC', 'Cơ hữu', '0', 'Khoa CNTT', 'TS', '11145', '2000-01-01', 'Huỳnh Minh Trí', NULL, NULL),
(36, 'GV', 'Thỉnh giảng', '0', 'Đại học công nghệ TP HCM', 'ThS ', '11146', '2000-01-01', 'Huỳnh Nam', NULL, NULL),
(37, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11147', '2000-01-01', 'Huỳnh Nguyễn Khắc Huy', NULL, NULL),
(38, 'GV', 'Thỉnh giảng', '0', 'Đại học công nghệ TPHCM', 'TS', '11148', '2000-01-01', 'Huỳnh Quốc Bảo', NULL, NULL),
(39, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11149', '2000-01-01', 'Huỳnh Thắng Được', NULL, NULL),
(40, NULL, 'M?i gi?ng', '0', 'Khoa GDTC', '', '11150', '2000-01-01', 'Huỳnh Thị Kim Quyên', NULL, NULL),
(41, 'GV', 'Thỉnh giảng', '0', '', 'TS', '11151', '2000-01-01', 'Huỳnh Thụy Bảo Trân', NULL, NULL),
(42, 'GV', 'Cơ hữu', '0', 'P. Đào tạo', 'ThS', '11152', '2000-01-01', 'Huỳnh Tổ Hạp', NULL, NULL),
(43, NULL, 'Thỉnh giảng', '0', 'Đại học công nghệ TP HCM', 'PGS.TS', '11153', '2000-01-01', 'Huỳnh Trung Hiếu', NULL, NULL),
(44, 'GV', 'Thỉnh giảng', '0', 'Học viện công nghệ bưu chính viễn thông', 'ThS', '11154', '2000-01-01', 'Huỳnh Trung Trụ', NULL, NULL),
(45, 'GV', 'Thỉnh giảng', '0', ' Sở khoa học công nghệ TPHCM', 'ThS', '11155', '2000-01-01', 'Khưu Minh Cảnh', NULL, NULL),
(46, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11156', '2000-01-01', 'Kiều My', NULL, NULL),
(47, NULL, '', '0', '', 'ThS', '11157', '2000-01-01', 'Kiều Phương Chi', NULL, NULL),
(48, 'GV', 'Mời giảng', '0', 'Phòng Khảo thí & đảm bảo chất lượng giáo dục', 'ThS', '11158', '2000-01-01', 'Lai Đình Khải', NULL, NULL),
(49, 'GV', 'Thỉnh giảng', '0', '', 'ThS', '11159', '2000-01-01', 'Lâm Hồng Bắc', NULL, NULL),
(50, NULL, 'Thỉnh giảng', '0', 'Đại học Khoa học tự nhiên', 'GS TS ', '11160', '2000-01-01', 'Lê Hoài Bắc', NULL, NULL),
(51, NULL, 'Thỉnh giảng', '0', 'Đại học khoa học tự nhiên', 'PGS. TS', '11161', '2000-01-01', 'Lê Hoàng Thái', NULL, NULL),
(52, 'GV', 'Mời giảng', '0', 'Trung tâm CNTT', 'ThS', '11162', '2000-01-01', 'Lê Hùng Thanh Nhựt', NULL, NULL),
(53, NULL, 'Mời giảng', '0', 'Khoa GDTC', '', '11163', '2000-01-01', 'Lê Kiên Giang', NULL, NULL),
(54, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'TS', '11164', '2000-01-01', 'Lê Minh Nhựt Triều', NULL, NULL),
(55, NULL, 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'PGS. TS', '11165', '2000-01-01', 'Lê Minh Triết', NULL, NULL),
(56, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'TS', '11166', '2000-01-01', 'Lê Minh Tuấn', NULL, NULL),
(57, 'GV', 'Mời giảng', '0', 'Trung tâm CNTT', 'TS', '11167', '2000-01-01', 'Lê Ngọc Anh', NULL, NULL),
(58, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11168', '2000-01-01', 'Lê Ngọc Kim Khánh', NULL, NULL),
(59, 'GV', 'Thỉnh giảng', '0', 'Trường Đại học khoa học tự nhiên', 'TS', '11169', '2000-01-01', 'Lê Nguyễn Hoài Nam', NULL, NULL),
(60, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11170', '2000-01-01', 'Lê Nhị Lãm Thúy', NULL, NULL),
(61, NULL, '', '0', 'Khoa CNTT', 'ThS', '11171', '2000-01-01', 'Lê Tấn Long', NULL, NULL),
(62, 'GV', 'Mời giảng', '0', 'Phòng Quản lý khoa học', 'ThS', '11172', '2000-01-01', 'Lê Thị Thúy Hằng', NULL, NULL),
(63, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'ThS', '11173', '2000-01-01', 'Lê Thị Tuyết Ngọc', NULL, NULL),
(64, 'GV', 'Thỉnh giảng', '0', 'Đại học công nghệ TP HCM', 'TS', '11174', '2000-01-01', 'Lê Trọng Ngọc', NULL, NULL),
(65, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11175', '2000-01-01', 'Lương Minh Huấn', NULL, NULL),
(66, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'TS', '11176', '2000-01-01', 'Lương Thị Hồng Cẩm', NULL, NULL),
(67, NULL, '', '0', 'Đại học Sư phạm TPHCM', 'ThS', '11177', '2000-01-01', 'Mai Vân Phương Vũ', NULL, NULL),
(68, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'TS', '11178', '2000-01-01', 'Nguyễn Ái Quốc', NULL, NULL),
(69, 'GV', 'Thỉnh giảng', '0', 'Đại học mở TP. HCM', 'ThS', '11179', '2000-01-01', 'Nguyễn Chí Thanh', NULL, NULL),
(70, 'GVC', 'Mời giảng', '0', 'Khoa GDCT', 'TS', '11180', '2000-01-01', 'Nguyễn Đình Bình', NULL, NULL),
(71, 'GV', 'Thỉnh giảng', '0', 'Đại học CNTT TPHCM', 'TS', '11181', '2000-01-01', 'Nguyễn Đình Hiển', NULL, NULL),
(72, NULL, 'Mời giảng', '0', 'Khoa Toán ứng dụng', '', '11182', '2000-01-01', 'Nguyễn Đình Huấn', NULL, NULL),
(73, 'GV', 'Thỉnh giảng', '0', 'Trường Đại học KHTN', 'TS', '11183', '2000-01-01', 'Nguyễn Duy Hàm', NULL, NULL),
(74, 'GVCC', 'Cơ hữu', '0', 'Khoa CNTT', 'PGS.TS', '11184', '2000-01-01', 'Nguyễn Hòa', NULL, NULL),
(75, 'GV', 'Thỉnh giảng', '0', 'Công Ty TNHH TM DV SKY INFORMATIC', 'ThS', '11185', '2000-01-01', 'Nguyễn Hoàng Phong', NULL, NULL),
(76, NULL, '', '0', 'Motorola Solutions', 'ThS', '11186', '2000-01-01', 'Nguyễn Hoàng Thịnh', NULL, NULL),
(77, 'GV', 'Thỉnh giảng', '0', 'Đại học công nghệ TP HCM', 'ThS', '11187', '2000-01-01', 'Nguyễn Hữu Quang', NULL, NULL),
(78, 'GV', 'Thỉnh giảng', '0', 'Đại học cảnh sát nhân dân', 'TS', '11188', '2000-01-01', 'Nguyễn Khắc Chiến', NULL, NULL),
(79, NULL, 'Th?nh giang', '0', 'Khoa CNTT', 'ThS', '11189', '2000-01-01', 'Nguyễn Lê Thanh Trúc', NULL, NULL),
(80, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'ThS', '11190', '2000-01-01', 'Nguyễn Lương Thái Bình', NULL, NULL),
(81, '', '', '0', 'Trung tâm học liệu', 'ThS ', '11191', '2000-01-01', 'Nguyễn Minh Cảnh', NULL, NULL),
(82, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11192', '2000-01-01', 'Nguyễn Nhựt Đông', NULL, NULL),
(83, 'GVC', 'Cơ hữu', '0', 'Khoa CNTT', 'TS', '11193', '2000-01-01', 'Nguyễn Quốc Huy', NULL, NULL),
(84, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11194', '2000-01-01', 'Nguyễn Quốc Phong', NULL, NULL),
(85, NULL, 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'GS. TS', '11195', '2000-01-01', 'Nguyễn Sum', NULL, NULL),
(86, 'GV', 'Thỉnh giảng', '0', 'Đại học Khoa học xã hội nhân văn', 'ThS', '11196', '2000-01-01', 'Nguyễn Tấn Công', NULL, NULL),
(87, NULL, 'Thỉnh giảng', '0', 'Đại học Bách Khoa TPHCM', 'PGS. TS', '11197', '2000-01-01', 'Nguyễn Thanh Bình', NULL, NULL),
(88, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'TS', '11198', '2000-01-01', 'Nguyễn Thành Huy', NULL, NULL),
(89, 'GV', 'Thỉnh giảng', '0', 'TMA Solution', 'ThS', '11199', '2000-01-01', 'Nguyễn Thành Nhân', NULL, NULL),
(90, NULL, '', '0', 'KHoa CNTT', 'ThS', '11200', '2000-01-01', 'Nguyễn Thanh Phước', NULL, NULL),
(91, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11201', '2000-01-01', 'Nguyễn Thanh Sang', NULL, NULL),
(92, 'GV', '', '0', 'Khoa Toán UD', 'TS', '11202', '2000-01-01', 'Nguyễn Thế Minh', NULL, NULL),
(93, NULL, 'Mời giảng', '0', 'Khoa GDTC', '', '11203', '2000-01-01', 'Nguyễn Thị Hoàng Anh', NULL, NULL),
(94, 'GV', 'Cơ hữu', '0', 'CNTT', 'ThS', '11204', '2000-01-01', 'Nguyễn Thị Hồng Anh', NULL, NULL),
(95, 'GV', 'Mời giảng', '0', 'Khoa ngoại ngữ', 'ThS', '11205', '2000-01-01', 'Nguyễn Thị Huệ', NULL, NULL),
(96, NULL, 'Thỉnh giảng', '0', 'Đại học tài nguyên môi trường', '', '11206', '2000-01-01', 'Nguyễn Thị Kiêm Ái', NULL, NULL),
(97, NULL, 'Thỉnh giảng', '0', '', '', '11207', '2000-01-01', 'Nguyễn Thị Ngọc Thanh', NULL, NULL),
(98, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'TS', '11208', '2000-01-01', 'Nguyễn Thị Thanh Lan', NULL, NULL),
(99, 'GV', 'Mời giảng', '0', 'Khoa nghệ thuật', 'ThS', '11209', '2000-01-01', 'Nguyễn Thị Thanh Trà', NULL, NULL),
(100, NULL, '', '0', 'Khoa Môi trường', 'TS', '11210', '2000-01-01', 'Nguyễn Thị Tuyết Nam', NULL, NULL),
(101, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11211', '2000-01-01', 'Nguyễn Thị Uyên Nhi', NULL, NULL),
(102, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'ThS', '11212', '2000-01-01', 'Nguyễn Thị Vân Khánh', NULL, NULL),
(103, 'GV', 'Thỉnh giảng', '0', 'Trường Đại học khoa học tự nhiên', 'TS', '11213', '2000-01-01', 'Nguyễn Trần Minh Thư', NULL, NULL),
(104, 'GV', 'Mời giảng', '0', 'Khoa ngoại ngữ', 'ThS', '11214', '2000-01-01', 'Nguyễn Trịnh Tố Anh', NULL, NULL),
(105, NULL, 'Mời giảng', '0', 'Khoa GDTC', '', '11215', '2000-01-01', 'Nguyễn Trung Sơn', NULL, NULL),
(106, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11216', '2000-01-01', 'Nguyễn Trung Tín', NULL, NULL),
(107, 'GV', 'Thỉnh giảng', '0', 'Đại học Bách Khoa TP.HCM', 'ThS', '11217', '2000-01-01', 'Nguyễn Trung Trực', NULL, NULL),
(108, NULL, 'Mời giảng', '0', 'Đại học Hutech', 'TS', '11218', '2000-01-01', 'Nguyễn Trường Hải', NULL, NULL),
(109, 'GVCC', 'Cơ hữu', '0', 'Đại học CNTT TPHCM', 'PGS.TS', '11219', '2000-01-01', 'Nguyễn Tuấn Đăng', NULL, NULL),
(110, 'GVC', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'TS', '11220', '2000-01-01', 'Nguyễn Văn Huấn', NULL, NULL),
(111, 'GV', 'Mời giảng', '0', 'Phòng Khảo thí & đảm bảo chất lượng giáo dục', 'ThS', '11221', '2000-01-01', 'Nguyễn Võ Lam Giang', NULL, NULL),
(112, NULL, 'Mời giảng', '0', 'Khoa GDCT', '', '11222', '2000-01-01', 'Phạm Đào Thịnh', NULL, NULL),
(113, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11223', '2000-01-01', 'Phạm Hoàng Vương', NULL, NULL),
(114, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'TS', '11224', '2000-01-01', 'Phạm Sỹ Nam', NULL, NULL),
(115, 'GVCC', 'Cơ hữu', '0', 'Khoa CNTT', 'PGS.TS', '11225', '2000-01-01', 'Phạm Thế Bảo', NULL, NULL),
(116, 'GV', 'Thỉnh giảng', '0', '', 'TS', '11226', '2000-01-01', 'Phạm Thị Bạch Huệ', NULL, NULL),
(117, 'GVC', 'Cơ hữu', '0', 'P. Tổ chức cán bộ', 'ThS', '11227', '2000-01-01', 'Phạm Thi Vương', NULL, NULL),
(118, 'GV', 'Thỉnh giảng', '0', 'Trường ĐH Tài nguyên và Môi trường Tp.HCM', 'ThS', '11228', '2000-01-01', 'Phạm Trọng Huynh', NULL, NULL),
(119, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'TS', '11229', '2000-01-01', 'Phan Đức Tuấn', NULL, NULL),
(120, NULL, 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'PGS. TS', '11230', '2000-01-01', 'Phan Hoàng Chơn', NULL, NULL),
(121, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11231', '2000-01-01', 'Phan Nguyệt Minh', NULL, NULL),
(122, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'TS', '11232', '2000-01-01', 'Phan Tấn Quốc', NULL, NULL),
(123, NULL, '', '0', 'Đại học Khoa học xã hội nhân văn', 'ThS', '11233', '2000-01-01', 'Phan Thành Huấn', NULL, NULL),
(124, 'GV', 'Mời giảng', '0', 'Trung tâm CNTT', 'ThS', '11234', '2000-01-01', 'Phan Thị Kim Loan', NULL, NULL),
(125, NULL, '', '0', 'Cao đẳng công nghệ Thủ Đức', 'TS', '11235', '2000-01-01', 'Phan Thị Thể', NULL, NULL),
(126, NULL, 'Thỉnh giảng', '0', '', '', '11236', '2000-01-01', 'Phan Trọng Nhân', NULL, NULL),
(127, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'ThS', '11237', '2000-01-01', 'Phan Trung Hiếu', NULL, NULL),
(128, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11238', '2000-01-01', 'Phùng Thái Thiên Trang', NULL, NULL),
(129, NULL, '', '0', 'Khoa Luật', 'ThS', '11239', '2000-01-01', 'Quách Thị Ngọc Thiện', NULL, NULL),
(130, 'GV', 'Thỉnh giảng', '0', 'Trường Đại học Công nghệ TPHCM', 'TS', '11240', '2000-01-01', 'Tạ Duy Công Chiến', NULL, NULL),
(131, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'ThS', '11241', '2000-01-01', 'Tạ Hoàng Thiện', NULL, NULL),
(132, NULL, 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'PGS. TS', '11242', '2000-01-01', 'Tạ Quang Sơn', NULL, NULL),
(133, 'GV', 'Thỉnh giảng', '0', 'Đại học CNTT TPHCM', 'ThS', '11243', '2000-01-01', 'Tạ Việt Phương', NULL, NULL),
(134, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'ThS', '11244', '2000-01-01', 'Thái Trần Phương Thảo', NULL, NULL),
(135, 'GV', 'Thỉnh giảng', '0', '', 'TS', '11245', '2000-01-01', 'Tô Bá Lâm', NULL, NULL),
(136, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'ThS', '11246', '2000-01-01', 'Trần Chí Hiếu', NULL, NULL),
(137, NULL, 'Thỉnh giảng', '0', 'Đại học Quốc tế Sài Gòn', 'PGS. TS', '11247', '2000-01-01', 'Trần Công Hùng', NULL, NULL),
(138, 'GV', 'Mời giảng', '0', 'Trung tâm CNTT', 'ThS', '11248', '2000-01-01', 'Trần Đình Nghĩa', NULL, NULL),
(139, 'GVC', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'TS', '11249', '2000-01-01', 'Trần Đức Thành', NULL, NULL),
(140, 'GV', 'Thỉnh giảng', '0', 'Học viện hàng không', 'ThS', '11250', '2000-01-01', 'Trần Đức Tùng', NULL, NULL),
(141, 'GV', 'Mời giảng', '0', 'Khoa điện tử viễn thông', 'ThS', '11251', '2000-01-01', 'Trần Minh Nhật', NULL, NULL),
(142, NULL, 'Thỉnh giảng', '0', '', '', '11252', '2000-01-01', 'Trần Minh Quang', NULL, NULL),
(143, NULL, 'Mời giảng', '0', 'Khoa ngoại ngữ', '', '11253', '2000-01-01', 'Trần Ngọc Mai', NULL, NULL),
(144, 'GV', 'Mời giảng', '0', 'Khoa Luật', 'ThS', '11254', '2000-01-01', 'Trần Ngọc Tuấn', NULL, NULL),
(145, NULL, '', '0', 'Phòng Đào tạo', 'ThS', '11255', '2000-01-01', 'Trần Nguyễn Minh Hiếu', NULL, NULL),
(146, 'GV', 'Thỉnh giảng', '0', 'Đại học công thương Tp.HCM', 'TS', '11256', '2000-01-01', 'Trần Quang Huy', NULL, NULL),
(147, 'GV', 'Thỉnh giảng', '0', 'Đại học Sư phạm TPHCM', 'TS', '11257', '2000-01-01', 'Trần Sơn Hải', NULL, NULL),
(148, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'ThS', '11258', '2000-01-01', 'Trần Sơn Lâm', NULL, NULL),
(149, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'TS', '11259', '2000-01-01', 'Trần Thanh Bình', NULL, NULL),
(150, NULL, '', '0', 'Đại học Sư phạm TPHCM', 'ThS', '11260', '2000-01-01', 'Trần Thanh Nhã', NULL, NULL),
(151, 'GV', 'Thỉnh giảng', '0', '', 'TS', '11261', '2000-01-01', 'Trần Thanh Trang', NULL, NULL),
(152, 'GV', 'Thỉnh giảng', '0', '', 'PGS.TS', '11262', '2000-01-01', 'Trần Văn Lăng', NULL, NULL),
(153, NULL, 'Mời giảng', '0', 'Khoa NN', '', '11263', '2000-01-01', 'Trịnh Hoàng Thanh Thảo', NULL, NULL),
(154, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'TS', '11264', '2000-01-01', 'Trịnh Tấn Đạt', NULL, NULL),
(155, 'GV', 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'ThS', '11265', '2000-01-01', 'Trương Hoàng Huy', NULL, NULL),
(156, 'GV', 'Cơ hữu', '0', 'Khoa CNTT', 'ThS', '11266', '2000-01-01', 'Trương Tấn Khoa', NULL, NULL),
(157, 'GV', 'Thỉnh giảng', '0', 'Đại học Gia Định', 'ThS', '11267', '2000-01-01', 'Từ Lãng Phiêu', NULL, NULL),
(158, 'GV', 'Thỉnh giảng', '0', 'Trường ĐH Sư phạm TPHCM', 'TS', '11268', '2000-01-01', 'Văn Thế Thành', NULL, NULL),
(159, NULL, '', '0', 'CTO của Công ty Eton.', 'ThS', '11269', '2000-01-01', 'Võ Hoàng Hải', NULL, NULL),
(160, NULL, 'Mời giảng', '0', 'Khoa Toán ứng dụng', 'PGS. TS', '11270', '2000-01-01', 'Võ Hoàng Hưng', NULL, NULL),
(161, 'GV', 'Thỉnh giảng', '0', 'Đại học công nghệ TP HCM', 'ThS', '11271', '2000-01-01', 'Võ Ngọc Tấn Phước', NULL, NULL),
(162, 'GV', 'Thỉnh giảng', '0', 'Đại học mở TP. HCM', 'ThS', '11272', '2000-01-01', 'Võ Thị Hồng Tuyết', NULL, NULL),
(163, 'GV', 'Mời giảng', '0', 'Khoa nghệ thuật', 'ThS', '11273', '2000-01-01', 'Võ Thị Nguyên', NULL, NULL),
(164, 'GV', 'Mời giảng', '0', 'Khoa ngoại ngữ', 'ThS', '11274', '2000-01-01', 'Võ Thụy Thanh Thảo', NULL, NULL),
(165, 'GV', 'Cơ hữu', '0', '', 'TS', '11275', '2000-01-01', 'Vũ Ngọc Thanh Sang', NULL, NULL),
(166, 'Trưởng Bộ Môn', 'Cơ hữu', '0', 'Đại học Hutech', 'TS', '11276', '2000-01-01', 'Vũ Thanh Hiền', 3, 6),
(167, 'Trưởng Bộ Môn', 'Cơ hữu', '0973289423', 'Đại học mở Tp.HCM', 'PGS. TS', '11277', '2000-01-01', 'Vũ Thanh Nguyên', 2, 5),
(168, 'Trưởng Bộ Môn', 'Cơ hữu', '0', 'Khoa Luật', 'TS', '11278', '2000-01-01', 'Vũ Thế Hoài', 1, 4),
(169, 'GV', 'Cơ hữu', '0973289423', 'Đại học Thủy Lợi', 'ThS', '11279', '2000-01-01', 'Vũ Thị Hạnh', 2, 3),
(170, 'giảng viên', 'Cơ hữu', '0332547222', 'Khoa Luật', 'PGS.TS', '11280', '2000-01-01', 'Vũ Thị Hồng Yến', 1, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giang_vien_hoc_phan`
--

CREATE TABLE `giang_vien_hoc_phan` (
  `id` bigint NOT NULL,
  `giang_vien_id` bigint DEFAULT NULL,
  `hoc_phan_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoc_ky`
--

CREATE TABLE `hoc_ky` (
  `id` bigint NOT NULL,
  `ten_hoc_ky` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoc_phan`
--

CREATE TABLE `hoc_phan` (
  `id` bigint NOT NULL,
  `he_so` float DEFAULT NULL,
  `mahp` varchar(255) DEFAULT NULL,
  `so_tiet_ly_thuyet` int DEFAULT NULL,
  `so_tiet_thuc_hanh` int DEFAULT NULL,
  `so_tin_chi` int DEFAULT NULL,
  `tenhp` varchar(255) DEFAULT NULL,
  `tong_so_tiet` int DEFAULT NULL,
  `bo_mon_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `hoc_phan`
--

INSERT INTO `hoc_phan` (`id`, `he_so`, `mahp`, `so_tiet_ly_thuyet`, `so_tiet_thuc_hanh`, `so_tin_chi`, `tenhp`, `tong_so_tiet`, `bo_mon_id`) VALUES
(2, 1, '100000', 45, 0, 3, 'Công nghệ thông tin và kỷ nguyên số', 45, NULL),
(3, 1, '100001', 45, 0, 3, 'Giới thiệu ngành CNTT', 45, NULL),
(4, 1, '833070', 30, 0, 2, 'Tin học ứng dụng (QTKD)', 30, NULL),
(5, 0.75, '841021', 30, 30, 3, 'Kiến trúc máy tính', 60, NULL),
(6, 0.75, '841022', 30, 30, 3, 'Hệ điều hành', 60, NULL),
(7, 0.75, '841040', 30, 30, 3, 'Kỹ thuật lập trình (cũ)', 60, NULL),
(8, 0.8, '841044', 45, 30, 4, 'Lập trình hướng đối tượng', 75, NULL),
(9, 0.75, '841046', 30, 30, 3, 'Phát triển ứng dụng web 2', 60, NULL),
(10, 0.8, '841047', 45, 30, 4, 'Công nghệ phần mềm', 75, NULL),
(11, 0.8, '841048', 45, 30, 4, 'Phân tích thiết kế HTTT', 75, NULL),
(12, 0.75, '841051', 30, 30, 3, 'Thiết kế giao diện', 60, NULL),
(13, 0.75, '841052', 30, 30, 3, 'Xây dựng phần mềm theo mô hình phân lớp', 60, NULL),
(14, 0.75, '841058', 30, 30, 3, 'Hệ điều hành mã nguồn mở', 60, NULL),
(15, 0.75, '841059', 30, 30, 3, 'Quản trị mạng', 60, NULL),
(16, 0.75, '841061', 30, 30, 3, 'Mạng máy tính nâng cao (cũ)', 60, NULL),
(17, 0.75, '841062', 30, 30, 3, 'Quản lý dự án công nghệ thông tin', 60, NULL),
(18, 0.75, '841065', 30, 30, 3, 'Các hệ quản trị cơ sở dữ liệu', 60, NULL),
(19, 0.8, '841067', 30, 30, 3, 'Thương mại điện tử & ứng dụng', 60, NULL),
(20, 0.75, '841068', 30, 30, 3, 'Hệ thống thông tin doanh nghiệp', 60, NULL),
(21, 1, '841070', 18, 0, 6, 'Thực tập tốt nghiệp (8 tuần)', 18, NULL),
(22, 1, '841071', 30, 15, 3, 'Dịch vụ web & ứng dụng', 45, NULL),
(23, 0.75, '841072', 30, 30, 3, 'Các công nghệ lập trình hiện đại', 60, NULL),
(24, 0.75, '841076', 30, 30, 3, 'Công nghệ phần mềm nâng cao', 60, NULL),
(25, 1, '841101', 60, 0, 4, 'Đại số', 60, NULL),
(26, 0.75, '841103', 30, 30, 3, 'Lý thuyết đồ thị (cũ)', 60, NULL),
(27, 0.8, '841107', 45, 30, 4, 'Lập trình Java', 75, NULL),
(28, 0.8, '841108', 45, 30, 4, 'Cấu trúc dữ liệu và giải thuật', 75, NULL),
(29, 0.8, '841109', 45, 30, 4, 'Cơ sở dữ liệu', 75, NULL),
(30, 0.8, '841110', 45, 30, 4, 'Cơ sở trí tuệ nhân tạo', 75, NULL),
(31, 0.8, '841111', 45, 30, 4, 'Phân tích thiết kế hướng đối tượng', 75, NULL),
(32, 0.75, '841113', 30, 30, 3, 'Phát triển phần mềm mã nguồn mở', 60, NULL),
(33, 0.75, '841114', 30, 30, 3, 'Phát triển ứng dụng trên thiết bị di động (cũ)', 60, NULL),
(34, 0.75, '841116', 30, 30, 3, 'Đồ họa máy tính', 60, NULL),
(35, 0.8, '841119', 45, 30, 4, 'An ninh mạng máy tính', 75, NULL),
(36, 0.75, '841120', 30, 30, 3, 'An toàn bảo mật dữ liệu trong HTTT', 60, NULL),
(37, 0.8, '841121', 45, 30, 4, 'Cơ sở dữ liệu phân tán', 75, NULL),
(38, 1, '841301', 60, 0, 4, 'Giải tích', 60, NULL),
(39, 0.8, '841302', 45, 30, 4, 'Cơ sở lập trình', 75, NULL),
(40, 0.8, '841303', 45, 30, 4, 'Kỹ thuật lập trình', 75, NULL),
(41, 0.75, '841304', 30, 30, 3, 'Phát triển ứng dụng web 1', 60, NULL),
(42, 0.75, '841307', 30, 30, 3, 'Lập trình mạng', 60, NULL),
(43, 0.75, '841308', 30, 30, 3, 'Khai phá dữ liệu', 60, NULL),
(44, 1, '841309', 45, 0, 3, 'Toán rời rạc', 45, NULL),
(45, 1, '841310', 45, 0, 3, 'Lý thuyết đồ thị', 45, NULL),
(50, 1, '841315', 45, 0, 3, 'Kỹ năng nghề nghiệp ngành CNTT', 45, NULL),
(51, 0.75, '841316', 30, 30, 3, 'Kiến thức nền tảng về bảo mật', 60, NULL),
(52, 1, '841317', 45, 0, 3, 'Đồ án chuẩn bị tốt nghiệp', 45, NULL),
(53, 0.75, '841318', 30, 30, 3, 'Phát triển hệ thống nhúng', 60, NULL),
(54, 0.75, '841319', 30, 30, 3, 'An toàn mạng không dây và di động', 60, NULL),
(55, 0.75, '841320', 30, 30, 3, 'Phát triển ứng dụng internet of things', 60, NULL),
(56, 0.75, '841321', 30, 30, 3, 'Thiết kế hệ thống mạng', 60, NULL),
(57, 1, '841322', 60, 0, 4, 'Máy học', 60, NULL),
(58, 0.75, '841323', 30, 30, 3, 'Điện toán đám mây', 60, NULL),
(59, 1, '841324', 30, 0, 2, 'Phương pháp luận nghiên cứu khoa học', 30, NULL),
(60, 1, '841328', 60, 0, 4, 'Seminar Công nghệ phần mềm', 60, NULL),
(61, 1, '841401', 45, 0, 3, 'Giải tích 1', 45, NULL),
(62, 1, '841402', 45, 0, 3, 'Đại số tuyến tính', 45, NULL),
(63, 1, '841403', 60, 0, 4, 'Cấu trúc rời rạc', 60, NULL),
(64, 0.75, '841404', 30, 30, 3, 'Mạng máy tính', 60, NULL),
(65, 1, '841405', 45, 0, 3, 'Xác suất thống kê', 45, NULL),
(66, 1, '841406', 45, 0, 3, 'Giải tích 2', 45, NULL),
(67, 0.8, '841407', 45, 30, 4, 'Các hệ quản trị cơ sở dữ liệu (2020)', 75, NULL),
(68, 0.8, '841408', 45, 30, 4, 'Kiểm thử phần mềm', 75, NULL),
(69, 1, '841409', 60, 0, 4, 'Mạng máy tính nâng cao', 60, NULL),
(70, 0.8, '841410', 45, 30, 4, 'An ninh mạng máy tính (2020)', 75, NULL),
(71, 0.8, '841411', 45, 30, 4, 'Quản trị mạng (2020)', 75, NULL),
(72, 0.8, '841413', 45, 30, 4, 'Cơ sở dữ liệu phân tán (2020)', 75, NULL),
(73, 1, '841414', 45, 0, 3, 'Thiết kế và phân tích giải thuật', 45, NULL),
(74, 1, '841415', 30, 0, 2, 'Luật pháp và CNTT', 30, NULL),
(75, 0.67, '841417', 15, 30, 2, 'Mỹ thuật ứng dụng trong CNTT', 45, NULL),
(76, 0.8, '841419', 45, 30, 4, 'Lập trình web và ứng dụng', 75, NULL),
(77, 0.8, '841422', 45, 30, 4, 'Ngôn ngữ lập trình Python', 75, NULL),
(78, 0.8, '841423', 45, 30, 4, 'Ngôn ngữ Lập trình c#', 75, NULL),
(79, 0.8, '841429', 45, 30, 4, 'Cơ sở dữ liệu nâng cao', 75, NULL),
(80, 1, '841430', 30, 0, 2, 'Nguyên lý và phương pháp lập trình', 30, NULL),
(81, 0.8, '841431', 45, 30, 4, 'Quản lý dự án phần mềm', 75, NULL),
(82, 0.8, '841432', 45, 30, 4, 'Phân tích dữ liệu', 75, NULL),
(83, 0.8, '841434', 45, 30, 4, 'Thương mại diện tử và ứng dụng', 75, NULL),
(84, 0.8, '841438', 45, 30, 4, 'Lập trình ứng dụng mạng', 75, NULL),
(85, 0.8, '841439', 45, 30, 4, 'Mạng không dây', 75, NULL),
(86, 0.8, '841440', 45, 30, 4, 'Phân tích và thiết kế mạng máy tính', 75, NULL),
(87, 1, '841442', 45, 0, 3, 'Mạng đa phương tiện và di động', 45, NULL),
(88, 1, '841443', 45, 0, 3, 'Phân tích mạng truyền thông và xã hội', 45, NULL),
(89, 1, '841444', 45, 0, 3, 'Quản trị và bảo trì hệ thống', 45, NULL),
(90, 1, '841445', 45, 0, 3, 'Hệ thống ảo và khả năng mở rộng dữ liệu', 45, NULL),
(91, 0.8, '841446', 45, 30, 4, 'Phân tích và xử lý ảnh', 75, NULL),
(92, 0.8, '841447', 45, 30, 4, 'Khai thác dữ liệu và ứng dụng', 75, NULL),
(93, 0.8, '841448', 45, 30, 4, 'Xử lý ngôn ngữ tự nhiên', 75, NULL),
(94, 0.8, '841449', 45, 30, 4, 'Nhập môn máy học', 75, NULL),
(95, 1, '841452', 45, 0, 3, 'Tính toán thông minh', 45, NULL),
(96, 0.8, '841453', 45, 30, 4, 'Phân tích và nhận dạng mẫu', 75, NULL),
(97, 0.8, '841456', 45, 30, 4, 'Công nghệ tri thức', 75, NULL),
(98, 0.8, '841457', 45, 30, 4, 'Học Sâu', 75, NULL),
(99, 0.8, '841458', 45, 30, 4, 'Trí tuệ nhân tạo nâng cao', 75, NULL),
(100, 0.8, '841461', 45, 30, 4, 'Nhập môn phát triển ứng dụng trên thiết bị di động', 75, NULL),
(101, 0.8, '841462', 45, 30, 4, 'Phát triển ứng dụng trên thiết bị di động', 75, NULL),
(102, 0.8, '841463', 45, 30, 4, 'Phát triển ứng dụng trên thiết bị di động nâng cao', 75, NULL),
(103, 0.8, '841464', 45, 30, 4, 'Lập trình web và ứng dụng nâng cao', 75, NULL),
(104, 0.8, '841467', 45, 30, 4, 'Công nghệ .NET', 75, NULL),
(105, 0.8, '841468', 45, 30, 4, 'Chuyên đề J2EE', 75, NULL),
(106, 1, '841476', 60, 0, 4, 'Đồ án chuyên ngành', 60, NULL),
(107, 0.8, '841479', 45, 30, 4, 'Kiến trúc phần mềm', 75, NULL),
(108, 0.8, '841480', 45, 30, 4, 'Xây dựng phần mềm theo mô hình phân lớp (2020)', 75, NULL),
(109, 0.8, '841481', 45, 30, 4, 'Thiết kế giao diện (2020)', 75, NULL),
(110, 1, '841482', 45, 0, 3, 'Seminar chuyên đề', 45, NULL),
(111, 1, '841483', 60, 0, 4, 'Mạng đa phương tiện và di động (KTPM)', 60, NULL),
(112, 1, '848010', 45, 0, 4, 'Giải tích số', 60, NULL),
(113, 1, '848013', 30, 15, 3, 'Kiến trúc máy tính và mạng máy tính', 45, NULL),
(114, 1, '848024', 30, 15, 3, 'Bảo mật mạng máy tính', 45, NULL),
(115, 0.8, '848028', 45, 30, 4, 'Phân tích và xử lý ảnh (Toán UD)', 75, NULL),
(116, 1, '848301', 0, 30, 2, 'Seminar chuyên đề tin học 2', 30, NULL),
(117, 0.8, '848411', 45, 30, 4, 'Seminar chuyên đề tin học 2', 75, NULL),
(118, 1, '848412', 60, 0, 4, 'Máy học (ToanUD)', 60, NULL),
(119, 1, '848416', 45, 0, 3, 'Khai thác dữ liệu (ToanUD)', 45, NULL),
(120, 0.8, '858009', 45, 30, 4, 'Cơ sở lập trình (KHDL)', 75, NULL),
(121, 0.8, '858010', 45, 30, 4, 'Cấu trúc dữ liệu và giải thuật (KHDL)', 75, NULL),
(122, 0.75, '858011', 30, 30, 3, 'Phương pháp lập trình hướng đối tượng (KHDL)', 60, NULL),
(123, 0.75, '858014', 30, 30, 3, 'Lập trình Python cơ bản (KHDL)', 60, NULL),
(124, 0.75, '858015', 30, 30, 3, 'Máy học (KHDL)', 60, NULL),
(136, 1, '865006', 30, 0, 2, 'Pháp luật đại cương', 30, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ke_hoach_chi_tiet`
--

CREATE TABLE `ke_hoach_chi_tiet` (
  `id` bigint NOT NULL,
  `so_luong_sinh_vien_nhom` int DEFAULT NULL,
  `tong_sinh_vien` int DEFAULT NULL,
  `tong_so_nhom` int DEFAULT NULL,
  `hoc_phan_id` bigint DEFAULT NULL,
  `ke_hoach_mo_mon_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ke_hoach_hoc`
--

CREATE TABLE `ke_hoach_hoc` (
  `id` bigint NOT NULL,
  `khoa_hoc_id` bigint DEFAULT NULL,
  `nganh_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ke_hoach_mo_mon`
--

CREATE TABLE `ke_hoach_mo_mon` (
  `id` bigint NOT NULL,
  `ngay_tao` datetime DEFAULT NULL,
  `hoc_ky_id` bigint DEFAULT NULL,
  `khoa_hoc_id` bigint DEFAULT NULL,
  `nam_hoc_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ke_hoach_mo_mon_nganh`
--

CREATE TABLE `ke_hoach_mo_mon_nganh` (
  `id` bigint NOT NULL,
  `ke_hoach_chi_tiet_id` bigint DEFAULT NULL,
  `nganh_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoa_hoc`
--

CREATE TABLE `khoa_hoc` (
  `id` bigint NOT NULL,
  `ma_khoa_hoc` varchar(255) DEFAULT NULL,
  `ten_khoa_hoc` varchar(255) DEFAULT NULL,
  `trang_thai_khoa_hoc` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `khoa_hoc`
--

INSERT INTO `khoa_hoc` (`id`, `ma_khoa_hoc`, `ten_khoa_hoc`, `trang_thai_khoa_hoc`) VALUES
(1, 'CNTT17', 'Khóa 17', NULL),
(2, 'CNTT18', 'Khóa 18', NULL),
(3, 'CNTT19', 'Khóa 19', NULL),
(4, 'CNTT20', 'Khóa 20', NULL),
(5, 'CNTT21', 'Khóa 21', NULL),
(6, 'CNTT22', 'Khóa 22', NULL),
(7, 'CNTT23', 'Khóa 23', NULL),
(8, 'CNTT24', 'Khóa 24', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lop_hoc`
--

CREATE TABLE `lop_hoc` (
  `id` bigint NOT NULL,
  `ma_lop` varchar(255) DEFAULT NULL,
  `sosvnam` int DEFAULT NULL,
  `sosvnu` int DEFAULT NULL,
  `so_sinh_vien_hien_tai` int DEFAULT NULL,
  `ten_lop` varchar(255) DEFAULT NULL,
  `khoa_hoc` bigint DEFAULT NULL,
  `nganh` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nam_hoc`
--

CREATE TABLE `nam_hoc` (
  `id` bigint NOT NULL,
  `hoc_ky` varchar(255) DEFAULT NULL,
  `ten_nam_hoc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `nam_hoc`
--

INSERT INTO `nam_hoc` (`id`, `hoc_ky`, `ten_nam_hoc`) VALUES
(1, 'HK1', '2024-2025'),
(2, 'HK2', '2024-2025'),
(3, 'HK3', '2024-2025');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nganh`
--

CREATE TABLE `nganh` (
  `id` bigint NOT NULL,
  `ten_nganh` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `nganh`
--

INSERT INTO `nganh` (`id`, `ten_nganh`) VALUES
(1, 'Công nghệ thông tin'),
(2, 'Công nghệ thông tin CLC'),
(3, 'Khoa học máy tính định hướng khoa học dữ liệu');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phan_cong_giang_vien`
--

CREATE TABLE `phan_cong_giang_vien` (
  `id` bigint NOT NULL,
  `loai_nhom` varchar(255) DEFAULT NULL,
  `ngay_cap_nhat` datetime DEFAULT NULL,
  `so_nhom` int DEFAULT NULL,
  `giang_vien_id` bigint DEFAULT NULL,
  `ke_hoach_chi_tiet_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `actived` bit(1) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remember_key` varchar(255) DEFAULT NULL,
  `authority_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `actived`, `avatar`, `created_date`, `email`, `full_name`, `password`, `remember_key`, `authority_name`) VALUES
(1, b'1', NULL, '2024-10-29', 'admin@gmail.com', 'ADMIN', '$2a$10$gGP5accSL84l1xzdkNCXSuNcdN/xfUD54vfacHl7oFbqUR0ZeT4by', NULL, 'ROLE_ADMIN'),
(2, b'1', 'http://res.cloudinary.com/dxqh3xpza/image/upload/v1730215556/lksfroy006mjfphjfu4v.jpg', '2024-10-29', 'gv1@gmail.com', 'Mai Hồng Vũ', '$2a$10$IHd2InA5oXpcRSSRjyMvN.MA8gZNqiQPbtWfp/cGKqbTVN/BBzWtO', NULL, 'ROLE_TEACHER'),
(3, b'1', 'http://res.cloudinary.com/dxqh3xpza/image/upload/v1730215580/jblr6hnlomlzxumkxadk.png', '2024-10-29', 'gv2@gmail.com', 'Lê hoàng tú', '$2a$10$hsMpVAet9HAaKK7z2wn6Del333mbcIsdEbda8j6A.ZvCpf6fE1Fe2', NULL, 'ROLE_TEACHER'),
(4, b'1', 'http://res.cloudinary.com/dxqh3xpza/image/upload/v1730215618/rp7r4z1efqrx7obazptp.jpg', '2024-10-29', 'tbm1@gmail.com', 'Hoàng thị hoài', '$2a$10$lmLfwcP8iBpmRxNzBDkrYuupeb4vd1W9uXTc3dcCeMlLuEfBOG3Te', NULL, 'ROLE_HEAD_DEPARTMENT'),
(5, b'1', 'http://res.cloudinary.com/dxqh3xpza/image/upload/v1730215663/au5flbma4e7nmhbsfsg6.png', '2024-10-29', 'tbm2@gmail.com', 'Hoàng mạnh hải', '$2a$10$TWVBXKo4NjHxa2INrkce7OCWpZW7RZGiP59xK.9qP3wuxvDinWf3C', NULL, 'ROLE_HEAD_DEPARTMENT'),
(6, b'1', 'http://res.cloudinary.com/dxqh3xpza/image/upload/v1730215691/kbupl9ylaqhkw4v0husy.png', '2024-10-29', 'tmb3@gmail.com', 'Trần anh tú', '$2a$10$RQnBNs.gGN.dgd3CZng3Je.6Y3d90ORyE1QvoiHT0t78UKNToMSWe', NULL, 'ROLE_HEAD_DEPARTMENT');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `authority`
--
ALTER TABLE `authority`
  ADD PRIMARY KEY (`name`);

--
-- Chỉ mục cho bảng `bai_viet`
--
ALTER TABLE `bai_viet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjotgbo8vql8u2t00yrv4cepmb` (`user_id`);

--
-- Chỉ mục cho bảng `bo_mon`
--
ALTER TABLE `bo_mon`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `chi_tiet_hoc`
--
ALTER TABLE `chi_tiet_hoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmyqagjng5eyw23xbikfw7luwd` (`hoc_ky_id`),
  ADD KEY `FK7rksadnynmq59utlvwfssv330` (`hoc_phan_id`),
  ADD KEY `FKaxy5s2kmxo43826u48bwc40c0` (`ke_hoach_hoc_id`);

--
-- Chỉ mục cho bảng `giang_vien`
--
ALTER TABLE `giang_vien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4852af41nefp0el2vernqd57b` (`bo_mon_id`),
  ADD KEY `FKi03nexh9pery1x644404g084r` (`user_id`);

--
-- Chỉ mục cho bảng `giang_vien_hoc_phan`
--
ALTER TABLE `giang_vien_hoc_phan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK98q1sojag88nwu92pykbr6qiw` (`giang_vien_id`),
  ADD KEY `FKc56uupsiq9njeb3rvuxvdp95y` (`hoc_phan_id`);

--
-- Chỉ mục cho bảng `hoc_ky`
--
ALTER TABLE `hoc_ky`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `hoc_phan`
--
ALTER TABLE `hoc_phan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm6w2fs6fg1910wwl4ong9guck` (`bo_mon_id`);

--
-- Chỉ mục cho bảng `ke_hoach_chi_tiet`
--
ALTER TABLE `ke_hoach_chi_tiet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq4i7ppbs5p3xhe0966yrxpl9v` (`hoc_phan_id`),
  ADD KEY `FK6fop3f47gfpsd6t9svbu4pn4r` (`ke_hoach_mo_mon_id`);

--
-- Chỉ mục cho bảng `ke_hoach_hoc`
--
ALTER TABLE `ke_hoach_hoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8cb0betkeiprio1nsbno77acn` (`khoa_hoc_id`),
  ADD KEY `FKdxwb4w6r4p29sclm2tivsci0w` (`nganh_id`);

--
-- Chỉ mục cho bảng `ke_hoach_mo_mon`
--
ALTER TABLE `ke_hoach_mo_mon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6yth35cswnq6596t5vmcbsel0` (`hoc_ky_id`),
  ADD KEY `FKc7jud9xo4fejirjfrufki0d7b` (`khoa_hoc_id`),
  ADD KEY `FKbpim2wv5q8qy0gy6tkge7jq3q` (`nam_hoc_id`);

--
-- Chỉ mục cho bảng `ke_hoach_mo_mon_nganh`
--
ALTER TABLE `ke_hoach_mo_mon_nganh`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKccivd9l1hs6na1n3ebt4bfq2g` (`ke_hoach_chi_tiet_id`),
  ADD KEY `FK8jqnx4vk0edmdcqtu5xm74dwr` (`nganh_id`);

--
-- Chỉ mục cho bảng `khoa_hoc`
--
ALTER TABLE `khoa_hoc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `lop_hoc`
--
ALTER TABLE `lop_hoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt48r76uubutsod4xcgmdpbc2t` (`khoa_hoc`),
  ADD KEY `FK1y73lxa75tue2qi5fnl6oiyc4` (`nganh`);

--
-- Chỉ mục cho bảng `nam_hoc`
--
ALTER TABLE `nam_hoc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `nganh`
--
ALTER TABLE `nganh`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `phan_cong_giang_vien`
--
ALTER TABLE `phan_cong_giang_vien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK363ae9mbq7t477lqo6lkov1mk` (`giang_vien_id`),
  ADD KEY `FK88ar0prf7l3fav1hv2nsr57j3` (`ke_hoach_chi_tiet_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq6r7e19l5xjmty0j0w6i2inlv` (`authority_name`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bai_viet`
--
ALTER TABLE `bai_viet`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `bo_mon`
--
ALTER TABLE `bo_mon`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `chi_tiet_hoc`
--
ALTER TABLE `chi_tiet_hoc`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `giang_vien`
--
ALTER TABLE `giang_vien`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=172;

--
-- AUTO_INCREMENT cho bảng `giang_vien_hoc_phan`
--
ALTER TABLE `giang_vien_hoc_phan`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `hoc_ky`
--
ALTER TABLE `hoc_ky`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `hoc_phan`
--
ALTER TABLE `hoc_phan`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=137;

--
-- AUTO_INCREMENT cho bảng `ke_hoach_chi_tiet`
--
ALTER TABLE `ke_hoach_chi_tiet`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ke_hoach_hoc`
--
ALTER TABLE `ke_hoach_hoc`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ke_hoach_mo_mon`
--
ALTER TABLE `ke_hoach_mo_mon`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ke_hoach_mo_mon_nganh`
--
ALTER TABLE `ke_hoach_mo_mon_nganh`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `khoa_hoc`
--
ALTER TABLE `khoa_hoc`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `lop_hoc`
--
ALTER TABLE `lop_hoc`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nam_hoc`
--
ALTER TABLE `nam_hoc`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `nganh`
--
ALTER TABLE `nganh`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `phan_cong_giang_vien`
--
ALTER TABLE `phan_cong_giang_vien`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bai_viet`
--
ALTER TABLE `bai_viet`
  ADD CONSTRAINT `FKjotgbo8vql8u2t00yrv4cepmb` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `chi_tiet_hoc`
--
ALTER TABLE `chi_tiet_hoc`
  ADD CONSTRAINT `FK7rksadnynmq59utlvwfssv330` FOREIGN KEY (`hoc_phan_id`) REFERENCES `hoc_phan` (`id`),
  ADD CONSTRAINT `FKaxy5s2kmxo43826u48bwc40c0` FOREIGN KEY (`ke_hoach_hoc_id`) REFERENCES `ke_hoach_hoc` (`id`),
  ADD CONSTRAINT `FKmyqagjng5eyw23xbikfw7luwd` FOREIGN KEY (`hoc_ky_id`) REFERENCES `hoc_ky` (`id`);

--
-- Các ràng buộc cho bảng `giang_vien`
--
ALTER TABLE `giang_vien`
  ADD CONSTRAINT `FK4852af41nefp0el2vernqd57b` FOREIGN KEY (`bo_mon_id`) REFERENCES `bo_mon` (`id`),
  ADD CONSTRAINT `FKi03nexh9pery1x644404g084r` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `giang_vien_hoc_phan`
--
ALTER TABLE `giang_vien_hoc_phan`
  ADD CONSTRAINT `FK98q1sojag88nwu92pykbr6qiw` FOREIGN KEY (`giang_vien_id`) REFERENCES `giang_vien` (`id`),
  ADD CONSTRAINT `FKc56uupsiq9njeb3rvuxvdp95y` FOREIGN KEY (`hoc_phan_id`) REFERENCES `hoc_phan` (`id`);

--
-- Các ràng buộc cho bảng `hoc_phan`
--
ALTER TABLE `hoc_phan`
  ADD CONSTRAINT `FKm6w2fs6fg1910wwl4ong9guck` FOREIGN KEY (`bo_mon_id`) REFERENCES `bo_mon` (`id`);

--
-- Các ràng buộc cho bảng `ke_hoach_chi_tiet`
--
ALTER TABLE `ke_hoach_chi_tiet`
  ADD CONSTRAINT `FK6fop3f47gfpsd6t9svbu4pn4r` FOREIGN KEY (`ke_hoach_mo_mon_id`) REFERENCES `ke_hoach_mo_mon` (`id`),
  ADD CONSTRAINT `FKq4i7ppbs5p3xhe0966yrxpl9v` FOREIGN KEY (`hoc_phan_id`) REFERENCES `hoc_phan` (`id`);

--
-- Các ràng buộc cho bảng `ke_hoach_hoc`
--
ALTER TABLE `ke_hoach_hoc`
  ADD CONSTRAINT `FK8cb0betkeiprio1nsbno77acn` FOREIGN KEY (`khoa_hoc_id`) REFERENCES `khoa_hoc` (`id`),
  ADD CONSTRAINT `FKdxwb4w6r4p29sclm2tivsci0w` FOREIGN KEY (`nganh_id`) REFERENCES `nganh` (`id`);

--
-- Các ràng buộc cho bảng `ke_hoach_mo_mon`
--
ALTER TABLE `ke_hoach_mo_mon`
  ADD CONSTRAINT `FK6yth35cswnq6596t5vmcbsel0` FOREIGN KEY (`hoc_ky_id`) REFERENCES `hoc_ky` (`id`),
  ADD CONSTRAINT `FKbpim2wv5q8qy0gy6tkge7jq3q` FOREIGN KEY (`nam_hoc_id`) REFERENCES `nam_hoc` (`id`),
  ADD CONSTRAINT `FKc7jud9xo4fejirjfrufki0d7b` FOREIGN KEY (`khoa_hoc_id`) REFERENCES `khoa_hoc` (`id`);

--
-- Các ràng buộc cho bảng `ke_hoach_mo_mon_nganh`
--
ALTER TABLE `ke_hoach_mo_mon_nganh`
  ADD CONSTRAINT `FK8jqnx4vk0edmdcqtu5xm74dwr` FOREIGN KEY (`nganh_id`) REFERENCES `nganh` (`id`),
  ADD CONSTRAINT `FKccivd9l1hs6na1n3ebt4bfq2g` FOREIGN KEY (`ke_hoach_chi_tiet_id`) REFERENCES `ke_hoach_chi_tiet` (`id`);

--
-- Các ràng buộc cho bảng `lop_hoc`
--
ALTER TABLE `lop_hoc`
  ADD CONSTRAINT `FK1y73lxa75tue2qi5fnl6oiyc4` FOREIGN KEY (`nganh`) REFERENCES `nganh` (`id`),
  ADD CONSTRAINT `FKt48r76uubutsod4xcgmdpbc2t` FOREIGN KEY (`khoa_hoc`) REFERENCES `khoa_hoc` (`id`);

--
-- Các ràng buộc cho bảng `phan_cong_giang_vien`
--
ALTER TABLE `phan_cong_giang_vien`
  ADD CONSTRAINT `FK363ae9mbq7t477lqo6lkov1mk` FOREIGN KEY (`giang_vien_id`) REFERENCES `giang_vien` (`id`),
  ADD CONSTRAINT `FK88ar0prf7l3fav1hv2nsr57j3` FOREIGN KEY (`ke_hoach_chi_tiet_id`) REFERENCES `ke_hoach_chi_tiet` (`id`);

--
-- Các ràng buộc cho bảng `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKq6r7e19l5xjmty0j0w6i2inlv` FOREIGN KEY (`authority_name`) REFERENCES `authority` (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
