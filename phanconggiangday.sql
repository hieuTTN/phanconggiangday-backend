-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3307
-- Thời gian đã tạo: Th10 01, 2024 lúc 03:42 PM
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
-- Cấu trúc bảng cho bảng `assignments`
--

CREATE TABLE `assignments` (
  `id` bigint NOT NULL,
  `assignment_status` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `assigned_user_id` bigint DEFAULT NULL,
  `created_by_id` bigint DEFAULT NULL,
  `school_year_id` bigint DEFAULT NULL,
  `subject_section_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
('ROLE_ADMIN', 'Ban chủ nhiệm khoa'),
('ROLE_ASSISTANT', 'Trợ lý đào tạo'),
('ROLE_HEAD_DEPARTMENT', 'Trưởng bộ môn'),
('ROLE_SPECIALIST', 'Chuyên viên Khoa'),
('ROLE_TEACHER', 'Giảng viên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `department`
--

CREATE TABLE `department` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `department`
--

INSERT INTO `department` (`id`, `name`) VALUES
(1, 'Ngành CNTT hệ chuẩn '),
(2, 'Ngành CNTT hệ CLC'),
(3, 'Ngành KTPM '),
(4, 'Ngành TTNT');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `feed_back`
--

CREATE TABLE `feed_back` (
  `id` bigint NOT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `created_date` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `assignments_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `notification`
--

CREATE TABLE `notification` (
  `id` bigint NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `is_read` bit(1) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `school_year`
--

CREATE TABLE `school_year` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `section`
--

CREATE TABLE `section` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `department_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `section`
--

INSERT INTO `section` (`id`, `name`, `department_id`) VALUES
(1, 'Kỹ thuật phần mềm', 1),
(2, 'Khoa học máy tính', 1),
(3, 'Hệ thống thông tin', 1),
(4, 'Kỹ thuật máy tính', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject`
--

CREATE TABLE `subject` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `credits` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject_section`
--

CREATE TABLE `subject_section` (
  `id` bigint NOT NULL,
  `semester` varchar(255) DEFAULT NULL,
  `section_id` bigint DEFAULT NULL,
  `subject_id` bigint DEFAULT NULL
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
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `remember_key` varchar(255) DEFAULT NULL,
  `token_fcm` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `authority_name` varchar(255) DEFAULT NULL,
  `department_id` bigint DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `actived`, `avatar`, `created_date`, `email`, `fullname`, `password`, `phone`, `remember_key`, `token_fcm`, `username`, `authority_name`, `department_id`, `address`, `dob`) VALUES
(1, b'1', NULL, '2024-09-26', 'hieutran02102804@gmail.com', 'ADMIN', '$2a$10$BK24gOINvxR1GvdRJ9sA3eHNHJ8pMShyjAhwUX9nUKj/v.bZ5aVVW', '113', NULL, NULL, 'hieutran02102804@gmail.com', 'ROLE_ADMIN', NULL, NULL, NULL),
(2, b'0', NULL, '2024-10-01', 'admin@gmail.com', 'ADMIN', '$2a$10$YNdjVH9ZpyC.vHRWLM05ZOD13Ox9Zc3.zGfC6e5464IhsnBNHOGMu', NULL, NULL, NULL, 'admin', 'ROLE_ADMIN', NULL, NULL, NULL),
(3, b'1', 'http://res.cloudinary.com/dxqh3xpza/image/upload/v1727794697/ekkyi8vt0h8sjykotnis.jpg', '2024-10-01', 'hieutran2102000@gmail.com', 'Lê Gia Khánh', '$2a$10$5LD1b/3uNaFk5eC0TfTppuEW7qOLCVTiIf5zoH88p4yQw9c/CuAWe', '0932478234', NULL, NULL, 'hieutran2102000@gmail.com', 'ROLE_TEACHER', 2, 'Hà nội', '2000-10-12');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `assignments`
--
ALTER TABLE `assignments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8s0pjiswptiynr35g6q258egv` (`assigned_user_id`),
  ADD KEY `FKdst5f4lsfa0i7otgo3t2s87n4` (`created_by_id`),
  ADD KEY `FKlqaqg0eig2eidbv2x4bpij4tj` (`school_year_id`),
  ADD KEY `FK4lj8pw57kpirx868j9ix62yo7` (`subject_section_id`);

--
-- Chỉ mục cho bảng `authority`
--
ALTER TABLE `authority`
  ADD PRIMARY KEY (`name`);

--
-- Chỉ mục cho bảng `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `feed_back`
--
ALTER TABLE `feed_back`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqb6k3hf9ad3kfobgx1u71pcl2` (`assignments_id`);

--
-- Chỉ mục cho bảng `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnk4ftb5am9ubmkv1661h15ds9` (`user_id`);

--
-- Chỉ mục cho bảng `school_year`
--
ALTER TABLE `school_year`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `section`
--
ALTER TABLE `section`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKte6p4d25dy5s85g2usl95v9kw` (`department_id`);

--
-- Chỉ mục cho bảng `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `subject_section`
--
ALTER TABLE `subject_section`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnea7bix6oodp0s7hq7lmsn5fm` (`section_id`),
  ADD KEY `FKha2g549d06ja10tojpea9d8bn` (`subject_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq6r7e19l5xjmty0j0w6i2inlv` (`authority_name`),
  ADD KEY `FKfi832e3qv89fq376fuh8920y4` (`department_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `assignments`
--
ALTER TABLE `assignments`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `department`
--
ALTER TABLE `department`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `feed_back`
--
ALTER TABLE `feed_back`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `notification`
--
ALTER TABLE `notification`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `school_year`
--
ALTER TABLE `school_year`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `section`
--
ALTER TABLE `section`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `subject`
--
ALTER TABLE `subject`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `subject_section`
--
ALTER TABLE `subject_section`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `assignments`
--
ALTER TABLE `assignments`
  ADD CONSTRAINT `FK4lj8pw57kpirx868j9ix62yo7` FOREIGN KEY (`subject_section_id`) REFERENCES `subject_section` (`id`),
  ADD CONSTRAINT `FK8s0pjiswptiynr35g6q258egv` FOREIGN KEY (`assigned_user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKdst5f4lsfa0i7otgo3t2s87n4` FOREIGN KEY (`created_by_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKlqaqg0eig2eidbv2x4bpij4tj` FOREIGN KEY (`school_year_id`) REFERENCES `school_year` (`id`);

--
-- Các ràng buộc cho bảng `feed_back`
--
ALTER TABLE `feed_back`
  ADD CONSTRAINT `FKqb6k3hf9ad3kfobgx1u71pcl2` FOREIGN KEY (`assignments_id`) REFERENCES `assignments` (`id`);

--
-- Các ràng buộc cho bảng `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `FKnk4ftb5am9ubmkv1661h15ds9` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `section`
--
ALTER TABLE `section`
  ADD CONSTRAINT `FKte6p4d25dy5s85g2usl95v9kw` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`);

--
-- Các ràng buộc cho bảng `subject_section`
--
ALTER TABLE `subject_section`
  ADD CONSTRAINT `FKha2g549d06ja10tojpea9d8bn` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `FKnea7bix6oodp0s7hq7lmsn5fm` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`);

--
-- Các ràng buộc cho bảng `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKfi832e3qv89fq376fuh8920y4` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  ADD CONSTRAINT `FKq6r7e19l5xjmty0j0w6i2inlv` FOREIGN KEY (`authority_name`) REFERENCES `authority` (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
