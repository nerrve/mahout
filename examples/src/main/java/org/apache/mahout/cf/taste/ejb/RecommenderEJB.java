/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.mahout.cf.taste.ejb;

import org.apache.mahout.cf.taste.common.Refreshable;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.Rescorer;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

/**
 * <p>Recommender EJB component interface.</p>
 *
 * @see RecommenderEJBLocal
 * @see org.apache.mahout.cf.taste.recommender.Recommender
 */
public interface RecommenderEJB extends EJBObject {

  /**
   * @see org.apache.mahout.cf.taste.recommender.Recommender#recommend(Comparable, int)
   */
  List<Comparable<?>> recommend(Object userID, int howMany) throws TasteException, RemoteException;

  /**
   * @see org.apache.mahout.cf.taste.recommender.Recommender#recommend(Comparable, int, Rescorer)
   */
  List<Comparable<?>> recommend(Object userID, int howMany, Rescorer<Comparable<?>> rescorer)
          throws TasteException, RemoteException;

  /**
   * @see org.apache.mahout.cf.taste.recommender.Recommender#estimatePreference(Comparable, Comparable)
   */
  double estimatePreference(Object userID, Object itemID) throws TasteException, RemoteException;

  /**
   * @see org.apache.mahout.cf.taste.recommender.Recommender#setPreference(Comparable, Comparable, double)
   */
  void setPreference(Object userID, Object itemID, double value)
          throws TasteException, RemoteException;

  /**
   * @see org.apache.mahout.cf.taste.recommender.Recommender#removePreference(Comparable, Comparable)
   */
  void removePreference(Object userID, Object itemID) throws TasteException, RemoteException;

  /**
   * @see org.apache.mahout.cf.taste.recommender.Recommender#refresh(java.util.Collection)
   */
  void refresh(Collection<Refreshable> alreadyRefreshed) throws RemoteException;

}
