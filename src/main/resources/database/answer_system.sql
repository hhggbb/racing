/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : answer_system

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-03-28 18:09:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for judge
-- ----------------------------
DROP TABLE IF EXISTS `judge`;
CREATE TABLE `judge` (
  `id` int(32) NOT NULL,
  `title` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '题目',
  `result` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '答案',
  `type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '题型\r\n  ',
  `score` int(255) DEFAULT NULL COMMENT '分值',
  `time` int(255) DEFAULT NULL COMMENT '答题时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='判断题';

-- ----------------------------
-- Records of judge
-- ----------------------------
INSERT INTO `judge` VALUES ('1', '经过长期努力，中国特色社会主义进入了新时代，这是我国发展新的历史方向。', '错', '判断题', '10', '30');
INSERT INTO `judge` VALUES ('2', '要高举爱国主义、社会主义旗帜，牢牢把握大团结大联合的主题，坚持一致性和多样性统一，找到最大公约数，画出最大同心圆。', '对', '判断题', '10', '30');
INSERT INTO `judge` VALUES ('3', '出台中央八项规定，严厉整治形式主义、官僚主义、享乐主义和奢靡之风，坚决反对特权。', '对', '判断题', '10', '30');
INSERT INTO `judge` VALUES ('4', '全面可持续发展是中国特色社会主义的本质要求和重要保障。', '错', '判断题', '10', '30');
INSERT INTO `judge` VALUES ('5', '人民是历史的创造者，是决定党和国家前途命运的根本力量。', '对', '判断题', '10', '30');
INSERT INTO `judge` VALUES ('6', '党内团结是党的生命、是党内政治生活积极健康的重要基础。', '错', '判断题', '10', '30');
INSERT INTO `judge` VALUES ('7', '脱贫攻坚战取得决定性进展，六千多万贫困人口稳定脱贫，贫困发生率从百分之十点二下降到百分之四以下。', '对', '判断题', '10', '30');
INSERT INTO `judge` VALUES ('8', '必须认识到，我国社会主要矛盾的变化，没有改变我们对我国社会主义所处历史阶段的判断，我国仍处于并将长期处于社会主义初级阶段的基本国情没有变，我国是世界最大发展中国家的国际地位没有变。', '对', '判断题', '10', '30');
INSERT INTO `judge` VALUES ('9', '我们要坚持党对人民军队的绝对领导。', '对', '判断题', '10', '30');
INSERT INTO `judge` VALUES ('10', '文化自信是一个国家、一个民族发展中更基本、更深沉、更持久的力量。', '对', '判断题', '10', '30');

-- ----------------------------
-- Table structure for match_rule
-- ----------------------------
DROP TABLE IF EXISTS `match_rule`;
CREATE TABLE `match_rule` (
  `id` int(32) NOT NULL,
  `type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型（格式严格遵守）：判断题，单选题，多选题，简答题，红歌竞猜，抢答题，风险题',
  `rule` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '规则',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='比赛规则';

-- ----------------------------
-- Records of match_rule
-- ----------------------------
INSERT INTO `match_rule` VALUES ('1', '判断题', '每题中只有一个正确答案（对或错），回答正确方可得分，每队答3题，每题10分，答题时间为30秒。');
INSERT INTO `match_rule` VALUES ('2', '单选题', '每题中只有一个正确答案，回答正确方可得分，每队答3题，每题10分，答题时间为30秒。');
INSERT INTO `match_rule` VALUES ('3', '多选题', '每题中有一个以上正确答案，全部回答正确方可得分，每队答2题，每题20分，答题时间为40秒。');
INSERT INTO `match_rule` VALUES ('4', '简答题', '口头回答由软件随机抽出的简答题，由评委打分，每队答2题，每题30分，答题时间为90秒。');
INSERT INTO `match_rule` VALUES ('5', '红歌竞猜', '暂无');
INSERT INTO `match_rule` VALUES ('6', '抢答题', '该环节中包含全部题型，由主持人发令，方可抢答，不同题型对应不同的分数，答对加相应的分，答错不扣分，但是如若出现提前抢答的，则视为犯规，取消该题的答题资格，并扣相应的分数。');
INSERT INTO `match_rule` VALUES ('7', '风险题', '本环节设三个分值，分别为10分,20分,30分，共两轮。每轮开始之前各小组在纸上选择是否答题以及选择答题分数，答对加上对应的分数，答错扣相应的分数。');

-- ----------------------------
-- Table structure for multiple_choice
-- ----------------------------
DROP TABLE IF EXISTS `multiple_choice`;
CREATE TABLE `multiple_choice` (
  `id` int(32) NOT NULL,
  `title` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '题目',
  `option1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '选项',
  `option2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `option3` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `option4` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `result` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '答案',
  `type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型',
  `score` int(255) DEFAULT NULL COMMENT '分数',
  `time` int(255) DEFAULT NULL COMMENT '时间（秒）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='多选题';

-- ----------------------------
-- Records of multiple_choice
-- ----------------------------
INSERT INTO `multiple_choice` VALUES ('1', '李强书记在会上指出，增强核心竞争力、增强经济免疫力，要认真落实去产能、（）五项重点任务。', '去库存', '去杠杆', '降成本', '补短板', 'ABCD', '多选题', '20', '40');
INSERT INTO `multiple_choice` VALUES ('2', '《政府工作报告》提出做好2017年全年工作，要围绕人产城融合，发展新经济、培育新动能，重点统筹推进()。', '产业振兴、创新驱动', '大城格局、枢纽带动', '实事惠民、服务联动', '政府建设、改革推动', 'ABCD', '多选题', '20', '40');
INSERT INTO `multiple_choice` VALUES ('3', ' 4月6日，教育部、国家发展改革委、财政部和人力资源社会保障部等四个部门日前共同印发《高中阶段教育普及攻坚计划（2017-2020年）》，提到2020年，普及高中阶段教育，全国各省（市、区）毛入学率均要达到90%以上，（   ）与（   ）招生规模要大体相当。', '普通高中 ', '中等职业教育', '初等教育', '小学教育', 'AB', '多选题', '20', '40');
INSERT INTO `multiple_choice` VALUES ('4', ' 中共中央总书记、国家主席、中央军委主席习近平3月5日下午参加十二届全国人大五次会议上海代表团审议时强调，解放思想，勇于担当，敢为人先，坚定践行新发展理念，深化改革开放，引领创新驱动，不断增强（）竞争力，加快建成社会主义现代化国际大都市。', '吸引力', '创造力', '竞争力', '政治实力', 'ABC', '多选题', '20', '40');
INSERT INTO `multiple_choice` VALUES ('5', '习近平总书记在中央财经领导小组第十五次会议上发表的重要讲话，研究深入推进去产能、防控金融风险、建立促进房地产市场平稳健康发展长效机制、振兴制造业等经济领域，啃下这些“硬骨头”，才能引导经济朝着（   ）的方向发展，实现稳中求进。', '更高质量', '更有效率', '更加公平', '更可持续', 'ABCD', '多选题', '20', '40');

-- ----------------------------
-- Table structure for quickly_answer
-- ----------------------------
DROP TABLE IF EXISTS `quickly_answer`;
CREATE TABLE `quickly_answer` (
  `id` int(32) NOT NULL,
  `type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '题型\r\n 判断题，单选题，多选题，简答题；只能出现这四种情况',
  `title` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '题目',
  `option1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '选项',
  `option2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `option3` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `option4` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `result` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '答案  单选多选的答案必须大写',
  `score` int(255) DEFAULT NULL COMMENT '分值',
  `time` int(255) DEFAULT NULL COMMENT '答题时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='抢答题';

-- ----------------------------
-- Records of quickly_answer
-- ----------------------------
INSERT INTO `quickly_answer` VALUES ('1', '判断题', '经过长期努力，中国特色社会主义进入了新时代，这是我国发展新的历史方向。', null, null, null, null, '错', '10', '10');
INSERT INTO `quickly_answer` VALUES ('2', '判断题', '文化自信是一个国家、一个民族发展中更基本、更深沉、更持久的力量。', null, null, null, null, '对', '10', '10');
INSERT INTO `quickly_answer` VALUES ('3', '判断题', '要高举爱国主义、社会主义旗帜，牢牢把握大团结大联合的主题，坚持一致性和多样性统一，找到最大公约数，画出最大同心圆。', null, null, null, null, '对', '10', '10');
INSERT INTO `quickly_answer` VALUES ('4', '单选题', '对马克思主义的信仰，对社会主义和共产主义的信念，是共产党人的（ ）。', '政治灵魂', '精神支柱', '政治底线', '道德底线', 'A', '10', '10');
INSERT INTO `quickly_answer` VALUES ('5', '单选题', '全面提高党的建设科学化水平，全党要增强紧迫感和责任感，牢牢把握的主线是（ ）', '加强党的执政能力建设', '加强先进性、纯洁性建设和党的执政能力建设', '加强先进性和纯洁性建设', '加强党的执政能力建设、先进性和纯洁性建设', 'D', '10', '10');
INSERT INTO `quickly_answer` VALUES ('6', '单选题', '党内（ ）是党的生命。', '监督 ', '纪律', '民主', '原则', 'C', '10', '10');
INSERT INTO `quickly_answer` VALUES ('7', '多选题', '李强书记在会上指出，增强核心竞争力、增强经济免疫力，要认真落实去产能、（）五项重点任务。', '去库存', '去杠杆', '降成本', '补短板', 'ABCD', '20', '10');
INSERT INTO `quickly_answer` VALUES ('8', '多选题', '《政府工作报告》提出做好2017年全年工作，要围绕人产城融合，发展新经济、培育新动能，重点统筹推进()。', '产业振兴、创新驱动', '大城格局、枢纽带动', '实事惠民、服务联动', '政府建设、改革推动', 'ABCD', '20', '10');
INSERT INTO `quickly_answer` VALUES ('9', '多选题', ' 4月6日，教育部、国家发展改革委、财政部和人力资源社会保障部等四个部门日前共同印发《高中阶段教育普及攻坚计划（2017-2020年）》，提到2020年，普及高中阶段教育，全国各省（市、区）毛入学率均要达到90%以上，（   ）与（   ）招生规模要大体相当。', '普通高中', '中等职业教育', '初等教育', '小学教育', 'AB', '20', '10');
INSERT INTO `quickly_answer` VALUES ('10', '简答题', '如何以创新引领实体经济转型升级？', null, null, null, null, '提升科技创新能力加快培育壮大新兴产业大力改造提升传统产业持续推进大众创业、万众创新', '30', '10');
INSERT INTO `quickly_answer` VALUES ('11', '简答题', '为什么要实行万众创业，大众创新？', null, null, null, null, '是以创业创新带动就业的有效方式是推动新旧动能转换和经济结构升级的重要力量是促进机会公平和社会纵向流动的现实渠道，要不断引向深入', '30', '10');
INSERT INTO `quickly_answer` VALUES ('12', '简答题', '实现全面建成小康社会奋斗目标必须遵循的原则，体现在什么？', null, null, null, null, '坚持人民主体地位坚持党的领导坚持科学发展坚持依法治国坚持深化改革坚持统筹国内国际两个大局', '30', '10');

-- ----------------------------
-- Table structure for red_song
-- ----------------------------
DROP TABLE IF EXISTS `red_song`;
CREATE TABLE `red_song` (
  `id` int(32) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '歌曲名，这是显示答案时候的名字',
  `name_src` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '歌曲名，这是引用路径，不要中文、空格（要求把所有歌曲重命名，并放在音频目录下），不要后缀',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='红歌';

-- ----------------------------
-- Records of red_song
-- ----------------------------
INSERT INTO `red_song` VALUES ('1', '卖女孩的小火柴啊啊啊', 'DJ_Siesta-Another_Day');
INSERT INTO `red_song` VALUES ('2', '刚刚', 'July-Cut_In_Love');
INSERT INTO `red_song` VALUES ('3', '他', 'ji_yi');
INSERT INTO `red_song` VALUES ('4', '一', 'July-My_Soul');
INSERT INTO `red_song` VALUES ('5', '人', 'July-In_Love');
INSERT INTO `red_song` VALUES ('6', '哦', 'yuan_kong');
INSERT INTO `red_song` VALUES ('7', '吗', 'Old_Memory');
INSERT INTO `red_song` VALUES ('8', '红歌', 'yi_qu_xiang_si');
INSERT INTO `red_song` VALUES ('9', '东方大道', 'Valentin-A_Little_Story');
INSERT INTO `red_song` VALUES ('10', '羽肿', 'yu_zhong-city');
INSERT INTO `red_song` VALUES ('11', '广工', 'yu_zhong-city');
INSERT INTO `red_song` VALUES ('12', '嚷嚷', 'yu_zhong-city');
INSERT INTO `red_song` VALUES ('13', '13', 'July-My_Soul');
INSERT INTO `red_song` VALUES ('14', '14', 'Old_Memory');
INSERT INTO `red_song` VALUES ('15', '15', 'July-My_Soul');
INSERT INTO `red_song` VALUES ('16', '16', 'July-My_Soul');
INSERT INTO `red_song` VALUES ('17', '17', 'Valentin-A_Little_Story');
INSERT INTO `red_song` VALUES ('18', '18', 'Valentin-A_Little_Story');
INSERT INTO `red_song` VALUES ('19', '19', 'Valentin-A_Little_Story');
INSERT INTO `red_song` VALUES ('20', '20', 'Valentin-A_Little_Story');

-- ----------------------------
-- Table structure for short_answer
-- ----------------------------
DROP TABLE IF EXISTS `short_answer`;
CREATE TABLE `short_answer` (
  `id` int(32) NOT NULL,
  `title` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '题目',
  `result` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '答案',
  `type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型',
  `score` int(255) DEFAULT NULL COMMENT '分数',
  `time` int(255) DEFAULT NULL COMMENT '时间（秒）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='简答题';

-- ----------------------------
-- Records of short_answer
-- ----------------------------
INSERT INTO `short_answer` VALUES ('1', '如何以创新引领实体经济转型升级？', '提升科技创新能力加快培育壮大新兴产业大力改造提升传统产业持续推进大众创业、万众创新', '简答题', '30', '90');
INSERT INTO `short_answer` VALUES ('2', '为什么要实行万众创业，大众创新？', '是以创业创新带动就业的有效方式是推动新旧动能转换和经济结构升级的重要力量是促进机会公平和社会纵向流动的现实渠道，要不断引向深入', '简答题', '30', '90');
INSERT INTO `short_answer` VALUES ('3', '实现全面建成小康社会奋斗目标必须遵循的原则，体现在什么？', '坚持人民主体地位坚持党的领导坚持科学发展坚持依法治国坚持深化改革坚持统筹国内国际两个大局', '简答题', '30', '90');
INSERT INTO `short_answer` VALUES ('4', '做好2017年政府工作，需要把握好哪五点？', '贯彻稳中求进工作总基调，保持战略实力坚持以推进供给侧结构性改革为主线适度扩大外需并提高有效性依靠创新推动新旧动能转换和结构优化升级着力解决人民群众普遍关心的突出问题', '简答题', '30', '90');
INSERT INTO `short_answer` VALUES ('5', '国家安全主要是指什么安全？', '国家政权主权统一和领土完整人民福祉经济社会可以持续发展国家其他利益相对处于没有危险和不受内外威胁的状态', '简答题', '30', '90');

-- ----------------------------
-- Table structure for single_choice
-- ----------------------------
DROP TABLE IF EXISTS `single_choice`;
CREATE TABLE `single_choice` (
  `id` int(32) NOT NULL,
  `title` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '题目',
  `option1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '选项',
  `option2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `option3` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `option4` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `result` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '答案',
  `type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型',
  `score` int(255) DEFAULT NULL COMMENT '分数',
  `time` int(255) DEFAULT NULL COMMENT '时间（秒）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='单选题';

-- ----------------------------
-- Records of single_choice
-- ----------------------------
INSERT INTO `single_choice` VALUES ('1', '对马克思主义的信仰，对社会主义和共产主义的信念，是共产党人的（ ）。', '政治灵魂', '精神支柱', '政治底线', '道德底线', 'A', '单选题', '10', '30');
INSERT INTO `single_choice` VALUES ('2', '全面提高党的建设科学化水平，全党要增强紧迫感和责任感，牢牢把握的主线是（ ）', '加强党的执政能力建设', '加强先进性、纯洁性建设和党的执政能力建设', '加强先进性和纯洁性建设', '加强党的执政能力建设、先进性和纯洁性建设', 'D', '单选题', '10', '30');
INSERT INTO `single_choice` VALUES ('3', '党内（ ）是党的生命。', '监督 ', '纪律', '民主', '原则', 'C', '单选题', '10', '30');
INSERT INTO `single_choice` VALUES ('4', '党的（ ）纪律是维护党的集中统一、保持党的战斗力的重要保障。', '政治', '组织', '经济工作', '群众工作', 'B', '单选题', '10', '30');
INSERT INTO `single_choice` VALUES ('5', '党员受到警告处分后的（ ）内，不得在党内提升职务和向', '半年', '一年', '两年', '三年', 'B', '单选题', '10', '30');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `score` int(30) DEFAULT '0' COMMENT '得分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='参赛者（团队）（用于必答题计分）只限于4或6支队伍，id必须从1开始';

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('1', '第一组', '0');
INSERT INTO `team` VALUES ('2', '第二组', '15');
INSERT INTO `team` VALUES ('3', '第三组', '0');
INSERT INTO `team` VALUES ('4', '第四组', '30');
INSERT INTO `team` VALUES ('5', '第五组', '0');
INSERT INTO `team` VALUES ('6', '第六组', '0');

-- ----------------------------
-- Table structure for team_quickly_answer
-- ----------------------------
DROP TABLE IF EXISTS `team_quickly_answer`;
CREATE TABLE `team_quickly_answer` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `score` int(30) DEFAULT NULL COMMENT '得分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='抢答题团队';

-- ----------------------------
-- Records of team_quickly_answer
-- ----------------------------
INSERT INTO `team_quickly_answer` VALUES ('21', '1', '0');
INSERT INTO `team_quickly_answer` VALUES ('22', '2', '0');
INSERT INTO `team_quickly_answer` VALUES ('23', '3', '0');
INSERT INTO `team_quickly_answer` VALUES ('24', '4', '0');
INSERT INTO `team_quickly_answer` VALUES ('25', '1', '0');
INSERT INTO `team_quickly_answer` VALUES ('26', '1', '0');

-- ----------------------------
-- Table structure for team_score_record
-- ----------------------------
DROP TABLE IF EXISTS `team_score_record`;
CREATE TABLE `team_score_record` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参赛者名字',
  `title_id` int(32) DEFAULT NULL COMMENT '题目id',
  `type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '题目类型',
  `score` int(32) DEFAULT NULL COMMENT '扣分或减分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='参赛者必答题分数记录表';

-- ----------------------------
-- Records of team_score_record
-- ----------------------------
