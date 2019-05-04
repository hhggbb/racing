import com.gk.RacingApplication;
import com.gk.action.SystemAction;
import com.gk.mapper.JudgeMapper;
import com.gk.model.*;
import com.gk.service.*;
import com.gk.utilsEntity.QuestionVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RacingApplication.class)
public class RacingApplicationTests {
	@Autowired
	private JudgeMapper judgeMapper;
	@Autowired
	private JudgeService judgeService;
	@Autowired
	private RedSongService redSongService;
	@Autowired
	private QuicklyAnswerService quicklyAnswerService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private TeamQuicklyAnswerService teamQuicklyAnswerService;
	@Autowired
	private SystemAction systemAction;
	@Autowired
	private MatchRuleService matchRuleService;
	@Autowired
	private TeamScoreRecordService teamScoreRecordService;

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void baseTest() {
//		System.out.println(("----- 测试啦啦啦 ------"));
//		List<Student> userList = studentMapper.selectList(null);
////        for (User user : userList) {
////            System.out.println(user);
////        }
////		Assert.assertEquals(5, userList.size());
//		userList.forEach(System.out::println);
//	}

//	@Test
//	public void serviceTest() {
//		System.out.println(("----- 测试2啦啦啦 ------"));
//		List<Student> users = studentService.selectAll();
//		users.forEach(System.out::println);
//	}

	@Test
	public void serviceTest02() {
		System.out.println(("----- 测试3啦啦啦 ------"));
		List<Judge> judges = judgeService.getBaseMapper().selectList(null);
		judges.forEach(System.out::println);
	}

	@Test
	public void judgeTest() {
		System.out.println(("----- 测试3啦啦啦 ------"));
		List<Judge> judges = judgeService.list();
		judges.forEach(System.out::println);
	}


	@Test
	public void redSongTest() {
		System.out.println(("----- 测试红歌啦啦啦 ------"));
		List<RedSong> redSongList = redSongService.list();
		redSongList.forEach(System.out::println);
	}

	@Test
	public void quicklyAnswerTest() {
		System.out.println(("----- 测试抢答题啦啦啦 ------"));
		List<QuicklyAnswer> quicklyAnswerList = quicklyAnswerService.list();
		quicklyAnswerList.forEach(System.out::println);
	}

	@Test
	public void teamTest() {
		System.out.println(("----- 测试team题啦啦啦 ------"));
		Team team=new Team();
		team.setName("hhh");
		team.setScore(56);
		boolean save = teamService.save(team);
		System.out.println(save);
		System.out.println(("----- 测试team2题啦啦啦 ------"));
		TeamQuicklyAnswer teamQuicklyAnswer=new TeamQuicklyAnswer();
		teamQuicklyAnswer.setName("uuuu");
		teamQuicklyAnswer.setScore(99);
		save = teamQuicklyAnswerService.save(teamQuicklyAnswer);
		System.out.println(save);

	}

	@Test
	public void quiclyAnswerTest() {
		System.out.println("----- 测试抢答题题啦啦啦 ------");
		QuicklyAnswer byId = quicklyAnswerService.getById(1);
		System.out.println(byId);
	}

	@Test
	public void teamTest02() {
		System.out.println("===============teamTest02测试啦===============");
		boolean b = teamService.countScore(18, "right", 30);
		System.out.println(b);
	}

	@Test
	public void questionTest02() {
		System.out.println("===============questionTest测试===============");
		List<QuestionVo> questionVoList = systemAction.putQuestion("抢答题");
		if(questionVoList!=null){
			questionVoList.forEach(System.out::println);
		}
	}

	@Test
	public void ruleTest() {
		System.out.println("===============rule测试===============");
		List<MatchRule> list = matchRuleService.list();
		list.forEach(System.out::println);
	}

	@Test
	public void ruleTest02() {
		System.out.println("===============rule测试2===============");
		MatchRule oneRule = matchRuleService.getOneRule("判断题");
		System.out.println(oneRule);
	}

	@Test
	public void TeamScoreTest02() {
		System.out.println("===============TeamScore测试2===============");
		boolean b = systemAction.insertRecord(5, "wrong", 10, "判断题");
		System.out.println(b);
	}
}
