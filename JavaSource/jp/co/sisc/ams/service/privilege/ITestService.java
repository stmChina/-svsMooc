package jp.co.sisc.ams.service.privilege;

import jp.co.sisc.ams.domain.privilege.TestResult;
import jp.co.sisc.frame.core.domain.AbstractVo;
import jp.co.sisc.frame.core.service.IBaseService;
import jp.co.sisc.ams.domain.privilege.Question;

import java.util.List;

public interface ITestService extends IBaseService<AbstractVo> {
	public TestResult initialTest(List<Question> questions, int num);
	
	public void dealCurrentRequest(TestResult result, int qNo, int aid);
}
