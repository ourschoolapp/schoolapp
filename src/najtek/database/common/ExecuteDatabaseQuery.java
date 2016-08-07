package najtek.database.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import najtek.domain.common.DomainObject;
import najtek.infra.user.User;

@Service
public class ExecuteDatabaseQuery {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public DomainObject selectOne(User inputDomainObject, String namespace,
			String method) {
		DomainObject resultDomainObject;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			String fullyQualifiedNamespace = namespace + "." + method;
			resultDomainObject = session.selectOne(fullyQualifiedNamespace, inputDomainObject);
		} finally {
			session.close();
		}

		return resultDomainObject;
	}
}
