/*
 * Copyright 2008-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.jpa.repository;

import static org.assertj.core.api.Assertions.*;
import static org.eclipse.persistence.Version.*;

import javax.persistence.Query;

import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.data.jpa.repository.sample.UserRepository;
import org.springframework.data.util.Version;
import org.springframework.test.context.ContextConfiguration;

/**
 * Testcase to run {@link UserRepository} integration tests on top of EclipseLink.
 *
 * @author Oliver Gierke
 * @author Thomas Darimont
 * @author Jens Schauder
 * @author Moritz Becker
 * @author Andrey Kovalev
 */
@ContextConfiguration(value = "classpath:eclipselink.xml")
public class EclipseLinkNamespaceUserRepositoryTests extends NamespaceUserRepositoryTests {

	/**
	 * Ignored until https://bugs.eclipse.org/bugs/show_bug.cgi?id=422450 is resolved.
	 */
	@Override
	public void sortByAssociationPropertyShouldUseLeftOuterJoin() {
	}

	/**
	 * Ignored until https://bugs.eclipse.org/bugs/show_bug.cgi?id=422450 is resolved.
	 */
	@Override
	public void sortByAssociationPropertyInPageableShouldUseLeftOuterJoin() {}

	/**
	 * Ignored until https://bugs.eclipse.org/bugs/show_bug.cgi?id=349477 is resolved.
	 */
	@Override
	public void findByElementCollectionAttribute() {}

	/**
	 * This test will fail once https://bugs.eclipse.org/bugs/show_bug.cgi?id=521915 is fixed.
	 */
	@Override
	@Test // DATAJPA-1172
	public void queryProvidesCorrectNumberOfParametersForNativeQuery() {

		Query query = em.createNativeQuery("select 1 from User where firstname=? and lastname=?");
		assertThat(query.getParameters()).describedAs(
				"Due to a bug eclipse has size 0. If this is no longer the case the special code path triggered in NamedOrIndexedQueryParameterSetter.registerExcessParameters can be removed")
				.hasSize(0);
	}

	/**
	 * Ignored until https://bugs.eclipse.org/bugs/show_bug.cgi?id=525319 is fixed.
	 */
	@Ignore
	@Override
	@Test // DATAJPA-980
	public void supportsProjectionsWithNativeQueries() {}

	/**
	 * Ignored until https://bugs.eclipse.org/bugs/show_bug.cgi?id=525319 is fixed.
	 */
	@Ignore
	@Override
	@Test // DATAJPA-1248
	public void supportsProjectionsWithNativeQueriesAndCamelCaseProperty() {}

	/**
	 * Ignored until https://bugs.eclipse.org/bugs/show_bug.cgi?id=525319 is fixed.
	 */
	@Ignore
	@Override
	@Test // DATAJPA-1301
	public void returnsNullValueInMap() {}

	/**
	 * TODO: Remove, once https://bugs.eclipse.org/bugs/show_bug.cgi?id=289141 is fixed.
	 */
	@Ignore
	@Override
	@Test
	public void bindsNativeQueryResultsToProjectionByName() {}

	/**
	 * Ignores the test. Reconsider once https://bugs.eclipse.org/bugs/show_bug.cgi?id=533240 is fixed.
	 */
	@Override
	public void findByEmptyArrayOfIntegers() throws Exception {}

	/**
	 * Ignores the test. Reconsider once https://bugs.eclipse.org/bugs/show_bug.cgi?id=533240 is fixed.
	 */
	@Override
	public void findByAgeWithEmptyArrayOfIntegersOrFirstName() {
	}

	/**
	 * Ignores the test. Reconsider once https://bugs.eclipse.org/bugs/show_bug.cgi?id=533240 is fixed.
	 */
	@Override
	public void findByEmptyCollectionOfIntegers() throws Exception {}

	/**
	 * Ignores the test. Reconsider once https://bugs.eclipse.org/bugs/show_bug.cgi?id=533240 is fixed.
	 */
	@Override
	public void findByEmptyCollectionOfStrings() throws Exception {}

	/**
	 * Ignores the test for EclipseLink.
	 */
	@Override
	@Test
	@Ignore
	public void savingUserThrowsAnException() {}

	/**
	 * Ignored until https://bugs.eclipse.org/bugs/show_bug.cgi?id=349477 is resolved.
	 */
	@Ignore
	@Override
	@Test // DATAJPA-1303
	public void findByElementCollectionInAttributeIgnoreCase() {}

	/**
	 * Ignored until https://bugs.eclipse.org/bugs/show_bug.cgi?id=349477 is resolved.
	 */
	@Ignore
	@Override
	@Test // DATAJPA-1303
	public void findByElementCollectionNotInAttributeIgnoreCase() {}

	/**
	 * Ignored until https://bugs.eclipse.org/bugs/show_bug.cgi?id=349477 is resolved.
	 */
	@Ignore
	@Override
	@Test // DATAJPA-1303
	public void findByElementVarargInAttributeIgnoreCase() {}

	/**
	 * Ignored until https://bugs.eclipse.org/bugs/show_bug.cgi?id=349477 is resolved.
	 */
	@Ignore
	@Override
	@Test // DATAJPA-1303
	public void findByElementCollectionInAttributeIgnoreCaseWithNulls() {}
}
