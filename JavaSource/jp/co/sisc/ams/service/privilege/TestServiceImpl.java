package jp.co.sisc.ams.service.privilege;

import org.springframework.stereotype.Service;

import jp.co.sisc.ams.domain.privilege.TestResult;
import jp.co.sisc.ams.domain.privilege.TestResultDDtl;
import jp.co.sisc.ams.domain.privilege.TestResultDtl;
import jp.co.sisc.frame.core.dao.IBaseDao;
import jp.co.sisc.frame.core.domain.AbstractVo;
import jp.co.sisc.frame.core.domain.BaseEntity;
import jp.co.sisc.frame.core.service.BaseServiceImpl;
import jp.co.sisc.ams.domain.privilege.Answer;
import jp.co.sisc.ams.domain.privilege.Question;
import java.util.*;

@Service
public class TestServiceImpl extends BaseServiceImpl<AbstractVo> implements ITestService {
	
	
	
	@Override
	public TestResult initialTest(List<Question> questions, int num) {
		System.out.print(this.getClass().getName() + "^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		List<Question> list = getRandomQuestions(questions, num);
		
		TestResult result = createNewTest(list);
		
		return result;
	}

	
	
	@Override
	public void dealCurrentRequest(TestResult result, int qNo, int aid) {
		TestResultDtl dtl = result.getDtls().get(qNo);
		
		for(TestResultDDtl dDtl : dtl.getdDtls()) {
			if (dDtl.getAnswer().getAid() == aid) {
				dDtl.setSelected("1");
				if (dDtl.getAnswer().getCorrectf().equals("1")) {
					dtl.setCorrect("1");
				}
			}
		}
		
	}



	private TestResult createNewTest(List<Question> list) {
		TestResult testResult = new TestResult();
		int disOrder = 1;
		List<TestResultDtl> dtls = new ArrayList<TestResultDtl>();
		for(Question question : list){
			TestResultDtl resultDtl = new TestResultDtl();
			resultDtl.setQuestion(question);
			resultDtl.setDisOrder(disOrder++);
			List<TestResultDDtl> dDtls = new ArrayList<TestResultDDtl>();
			int dtlDisOrder = 1;
			for(Answer answer : question.getAnswers()) {
				TestResultDDtl ddtl = new TestResultDDtl();
				ddtl.setAnswer(answer);
				switch(dtlDisOrder) {
				case 1:
				ddtl.setDisorder("A");
				break;
				case 2:
				ddtl.setDisorder("B");
				break;
				case 3:
				ddtl.setDisorder("C");
				break;
				case 4:
				ddtl.setDisorder("D");
				break;
				case 5:
				ddtl.setDisorder("E");
				break;
				case 6:
				ddtl.setDisorder("F");
				break;
				case 7:
				ddtl.setDisorder("G");
				break;
				case 8:
				ddtl.setDisorder("H");
				break;
				}
				dtlDisOrder++;
				dDtls.add(ddtl);
			}
			resultDtl.setdDtls(dDtls);
			
			dtls.add(resultDtl);
		}
		testResult.setDtls(dtls);
		return testResult;
	}

	@Override
	protected IBaseDao<BaseEntity> getBaseDao() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 选择出规定数量考试题
	 * @param questions
	 * @param num
	 * @return
	 */
	private List<Question> getRandomQuestions(List<Question> questions, int num) {
		if (questions == null || questions.size() == 0)
			return null;
		List<Question> list = new ArrayList<Question>();
		Random random = new Random();
		
		while(num > 0) {
			int randomInt = random.nextInt(questions.size()) % questions.size();
			
			System.out.println(randomInt + "$$$$$$$$$$$$$$$$$$$$$$$");
			Question question = questions.get(randomInt);
			
			if (!list.contains(question)) {
				list.add(question);
				num--;
			}
			
		}
		return list;
	}
	
}
