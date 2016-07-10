package jp.co.sisc.ams.web.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import jp.co.sisc.ams.domain.privilege.Question;
import jp.co.sisc.ams.domain.privilege.TestResult;
import jp.co.sisc.ams.service.privilege.*;



@Controller
@SessionAttributes("test")
public class TestController {
	
	public static final int QUESTIONNUM = 5;
	
	public TestController() {
		super();
		System.out.println("test!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	@Autowired
	private ITestService testService;
	
	@Autowired
	private IQuestService questService;

	@Autowired(required=true)
	private HttpServletRequest request;
	
	/**
	 * 测试初始化，需要生成一份试卷
	 * @return
	 */
	@RequestMapping (value = "/page/test/initial.html")
	public ModelAndView testInitial() {
		List<Question> questions = questService.getQuestions();
		
		TestResult result = testService.initialTest(questions, QUESTIONNUM);
		System.out.println("Success!!!!!");
		ModelAndView mAndv = new ModelAndView();
		mAndv.addObject("test", result);
		mAndv.addObject("question", result.getDtls().get(0));
		mAndv.addObject("qNo", result.getDtls().get(0).getDisOrder());
		mAndv.setViewName("test/test");
		return mAndv;
	}
	
	/**
	 * 显示下一道题
	 * @return
	 */
	@RequestMapping (value = "/page/test/next.html", method = RequestMethod.POST)
	public ModelAndView next(@ModelAttribute("test") TestResult testResult) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		int qNo = Integer.parseInt(request.getParameter("disOrder"));
		
		if (qNo == testResult.getDtls().size())
			return new ModelAndView("test/finish");
		
		testService.dealCurrentRequest(testResult, qNo, aid);
		
		ModelAndView mAndv = new ModelAndView();
		mAndv.addObject("question", testResult.getDtls().get(qNo));
		mAndv.addObject("qNo", testResult.getDtls().get(qNo).getDisOrder());
		mAndv.setViewName("test/test");
		return mAndv;
	}
	
}
