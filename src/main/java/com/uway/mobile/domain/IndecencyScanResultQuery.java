package com.uway.mobile.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndecencyScanResultQuery {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Integer pageNo = 1;

	protected Integer startRow;

	protected Integer pageSize = 10;

	protected String fields;

	public IndecencyScanResultQuery() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
		this.startRow = (pageNo - 1) * this.pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		this.startRow = (pageNo - 1) * this.pageSize;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getFields() {
		return fields;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andAssertinfoidIsNull() {
			addCriterion("assertInfoId is null");
			return (Criteria) this;
		}

		public Criteria andAssertinfoidIsNotNull() {
			addCriterion("assertInfoId is not null");
			return (Criteria) this;
		}

		public Criteria andAssertinfoidEqualTo(Integer value) {
			addCriterion("assertInfoId =", value, "assertinfoid");
			return (Criteria) this;
		}

		public Criteria andAssertinfoidNotEqualTo(Integer value) {
			addCriterion("assertInfoId <>", value, "assertinfoid");
			return (Criteria) this;
		}

		public Criteria andAssertinfoidGreaterThan(Integer value) {
			addCriterion("assertInfoId >", value, "assertinfoid");
			return (Criteria) this;
		}

		public Criteria andAssertinfoidGreaterThanOrEqualTo(Integer value) {
			addCriterion("assertInfoId >=", value, "assertinfoid");
			return (Criteria) this;
		}

		public Criteria andAssertinfoidLessThan(Integer value) {
			addCriterion("assertInfoId <", value, "assertinfoid");
			return (Criteria) this;
		}

		public Criteria andAssertinfoidLessThanOrEqualTo(Integer value) {
			addCriterion("assertInfoId <=", value, "assertinfoid");
			return (Criteria) this;
		}

		public Criteria andAssertinfoidIn(List<Integer> values) {
			addCriterion("assertInfoId in", values, "assertinfoid");
			return (Criteria) this;
		}

		public Criteria andAssertinfoidNotIn(List<Integer> values) {
			addCriterion("assertInfoId not in", values, "assertinfoid");
			return (Criteria) this;
		}

		public Criteria andAssertinfoidBetween(Integer value1, Integer value2) {
			addCriterion("assertInfoId between", value1, value2, "assertinfoid");
			return (Criteria) this;
		}

		public Criteria andAssertinfoidNotBetween(Integer value1, Integer value2) {
			addCriterion("assertInfoId not between", value1, value2, "assertinfoid");
			return (Criteria) this;
		}

		public Criteria andOriurlIsNull() {
			addCriterion("oriurl is null");
			return (Criteria) this;
		}

		public Criteria andOriurlIsNotNull() {
			addCriterion("oriurl is not null");
			return (Criteria) this;
		}

		public Criteria andOriurlEqualTo(String value) {
			addCriterion("oriurl =", value, "oriurl");
			return (Criteria) this;
		}

		public Criteria andOriurlNotEqualTo(String value) {
			addCriterion("oriurl <>", value, "oriurl");
			return (Criteria) this;
		}

		public Criteria andOriurlGreaterThan(String value) {
			addCriterion("oriurl >", value, "oriurl");
			return (Criteria) this;
		}

		public Criteria andOriurlGreaterThanOrEqualTo(String value) {
			addCriterion("oriurl >=", value, "oriurl");
			return (Criteria) this;
		}

		public Criteria andOriurlLessThan(String value) {
			addCriterion("oriurl <", value, "oriurl");
			return (Criteria) this;
		}

		public Criteria andOriurlLessThanOrEqualTo(String value) {
			addCriterion("oriurl <=", value, "oriurl");
			return (Criteria) this;
		}

		public Criteria andOriurlLike(String value) {
			addCriterion("oriurl like", value, "oriurl");
			return (Criteria) this;
		}

		public Criteria andOriurlNotLike(String value) {
			addCriterion("oriurl not like", value, "oriurl");
			return (Criteria) this;
		}

		public Criteria andOriurlIn(List<String> values) {
			addCriterion("oriurl in", values, "oriurl");
			return (Criteria) this;
		}

		public Criteria andOriurlNotIn(List<String> values) {
			addCriterion("oriurl not in", values, "oriurl");
			return (Criteria) this;
		}

		public Criteria andOriurlBetween(String value1, String value2) {
			addCriterion("oriurl between", value1, value2, "oriurl");
			return (Criteria) this;
		}

		public Criteria andOriurlNotBetween(String value1, String value2) {
			addCriterion("oriurl not between", value1, value2, "oriurl");
			return (Criteria) this;
		}

		public Criteria andUrlIsNull() {
			addCriterion("url is null");
			return (Criteria) this;
		}

		public Criteria andUrlIsNotNull() {
			addCriterion("url is not null");
			return (Criteria) this;
		}

		public Criteria andUrlEqualTo(String value) {
			addCriterion("url =", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotEqualTo(String value) {
			addCriterion("url <>", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThan(String value) {
			addCriterion("url >", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThanOrEqualTo(String value) {
			addCriterion("url >=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThan(String value) {
			addCriterion("url <", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThanOrEqualTo(String value) {
			addCriterion("url <=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLike(String value) {
			addCriterion("url like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotLike(String value) {
			addCriterion("url not like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlIn(List<String> values) {
			addCriterion("url in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotIn(List<String> values) {
			addCriterion("url not in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlBetween(String value1, String value2) {
			addCriterion("url between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotBetween(String value1, String value2) {
			addCriterion("url not between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andScantimeIsNull() {
			addCriterion("scantime is null");
			return (Criteria) this;
		}

		public Criteria andScantimeIsNotNull() {
			addCriterion("scantime is not null");
			return (Criteria) this;
		}

		public Criteria andScantimeEqualTo(Date value) {
			addCriterion("scantime =", value, "scantime");
			return (Criteria) this;
		}

		public Criteria andScantimeNotEqualTo(Date value) {
			addCriterion("scantime <>", value, "scantime");
			return (Criteria) this;
		}

		public Criteria andScantimeGreaterThan(Date value) {
			addCriterion("scantime >", value, "scantime");
			return (Criteria) this;
		}

		public Criteria andScantimeGreaterThanOrEqualTo(Date value) {
			addCriterion("scantime >=", value, "scantime");
			return (Criteria) this;
		}

		public Criteria andScantimeLessThan(Date value) {
			addCriterion("scantime <", value, "scantime");
			return (Criteria) this;
		}

		public Criteria andScantimeLessThanOrEqualTo(Date value) {
			addCriterion("scantime <=", value, "scantime");
			return (Criteria) this;
		}

		public Criteria andScantimeIn(List<Date> values) {
			addCriterion("scantime in", values, "scantime");
			return (Criteria) this;
		}

		public Criteria andScantimeNotIn(List<Date> values) {
			addCriterion("scantime not in", values, "scantime");
			return (Criteria) this;
		}

		public Criteria andScantimeBetween(Date value1, Date value2) {
			addCriterion("scantime between", value1, value2, "scantime");
			return (Criteria) this;
		}

		public Criteria andScantimeNotBetween(Date value1, Date value2) {
			addCriterion("scantime not between", value1, value2, "scantime");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andSensitypeIsNull() {
			addCriterion("sensitype is null");
			return (Criteria) this;
		}

		public Criteria andSensitypeIsNotNull() {
			addCriterion("sensitype is not null");
			return (Criteria) this;
		}

		public Criteria andSensitypeEqualTo(String value) {
			addCriterion("sensitype =", value, "sensitype");
			return (Criteria) this;
		}

		public Criteria andSensitypeNotEqualTo(String value) {
			addCriterion("sensitype <>", value, "sensitype");
			return (Criteria) this;
		}

		public Criteria andSensitypeGreaterThan(String value) {
			addCriterion("sensitype >", value, "sensitype");
			return (Criteria) this;
		}

		public Criteria andSensitypeGreaterThanOrEqualTo(String value) {
			addCriterion("sensitype >=", value, "sensitype");
			return (Criteria) this;
		}

		public Criteria andSensitypeLessThan(String value) {
			addCriterion("sensitype <", value, "sensitype");
			return (Criteria) this;
		}

		public Criteria andSensitypeLessThanOrEqualTo(String value) {
			addCriterion("sensitype <=", value, "sensitype");
			return (Criteria) this;
		}

		public Criteria andSensitypeLike(String value) {
			addCriterion("sensitype like", value, "sensitype");
			return (Criteria) this;
		}

		public Criteria andSensitypeNotLike(String value) {
			addCriterion("sensitype not like", value, "sensitype");
			return (Criteria) this;
		}

		public Criteria andSensitypeIn(List<String> values) {
			addCriterion("sensitype in", values, "sensitype");
			return (Criteria) this;
		}

		public Criteria andSensitypeNotIn(List<String> values) {
			addCriterion("sensitype not in", values, "sensitype");
			return (Criteria) this;
		}

		public Criteria andSensitypeBetween(String value1, String value2) {
			addCriterion("sensitype between", value1, value2, "sensitype");
			return (Criteria) this;
		}

		public Criteria andSensitypeNotBetween(String value1, String value2) {
			addCriterion("sensitype not between", value1, value2, "sensitype");
			return (Criteria) this;
		}

		public Criteria andOccurenceIsNull() {
			addCriterion("occurence is null");
			return (Criteria) this;
		}

		public Criteria andOccurenceIsNotNull() {
			addCriterion("occurence is not null");
			return (Criteria) this;
		}

		public Criteria andOccurenceEqualTo(String value) {
			addCriterion("occurence =", value, "occurence");
			return (Criteria) this;
		}

		public Criteria andOccurenceNotEqualTo(String value) {
			addCriterion("occurence <>", value, "occurence");
			return (Criteria) this;
		}

		public Criteria andOccurenceGreaterThan(String value) {
			addCriterion("occurence >", value, "occurence");
			return (Criteria) this;
		}

		public Criteria andOccurenceGreaterThanOrEqualTo(String value) {
			addCriterion("occurence >=", value, "occurence");
			return (Criteria) this;
		}

		public Criteria andOccurenceLessThan(String value) {
			addCriterion("occurence <", value, "occurence");
			return (Criteria) this;
		}

		public Criteria andOccurenceLessThanOrEqualTo(String value) {
			addCriterion("occurence <=", value, "occurence");
			return (Criteria) this;
		}

		public Criteria andOccurenceLike(String value) {
			addCriterion("occurence like", value, "occurence");
			return (Criteria) this;
		}

		public Criteria andOccurenceNotLike(String value) {
			addCriterion("occurence not like", value, "occurence");
			return (Criteria) this;
		}

		public Criteria andOccurenceIn(List<String> values) {
			addCriterion("occurence in", values, "occurence");
			return (Criteria) this;
		}

		public Criteria andOccurenceNotIn(List<String> values) {
			addCriterion("occurence not in", values, "occurence");
			return (Criteria) this;
		}

		public Criteria andOccurenceBetween(String value1, String value2) {
			addCriterion("occurence between", value1, value2, "occurence");
			return (Criteria) this;
		}

		public Criteria andOccurenceNotBetween(String value1, String value2) {
			addCriterion("occurence not between", value1, value2, "occurence");
			return (Criteria) this;
		}

		public Criteria andEsidIsNull() {
			addCriterion("esid is null");
			return (Criteria) this;
		}

		public Criteria andEsidIsNotNull() {
			addCriterion("esid is not null");
			return (Criteria) this;
		}

		public Criteria andEsidEqualTo(String value) {
			addCriterion("esid =", value, "esid");
			return (Criteria) this;
		}

		public Criteria andEsidNotEqualTo(String value) {
			addCriterion("esid <>", value, "esid");
			return (Criteria) this;
		}

		public Criteria andEsidGreaterThan(String value) {
			addCriterion("esid >", value, "esid");
			return (Criteria) this;
		}

		public Criteria andEsidGreaterThanOrEqualTo(String value) {
			addCriterion("esid >=", value, "esid");
			return (Criteria) this;
		}

		public Criteria andEsidLessThan(String value) {
			addCriterion("esid <", value, "esid");
			return (Criteria) this;
		}

		public Criteria andEsidLessThanOrEqualTo(String value) {
			addCriterion("esid <=", value, "esid");
			return (Criteria) this;
		}

		public Criteria andEsidLike(String value) {
			addCriterion("esid like", value, "esid");
			return (Criteria) this;
		}

		public Criteria andEsidNotLike(String value) {
			addCriterion("esid not like", value, "esid");
			return (Criteria) this;
		}

		public Criteria andEsidIn(List<String> values) {
			addCriterion("esid in", values, "esid");
			return (Criteria) this;
		}

		public Criteria andEsidNotIn(List<String> values) {
			addCriterion("esid not in", values, "esid");
			return (Criteria) this;
		}

		public Criteria andEsidBetween(String value1, String value2) {
			addCriterion("esid between", value1, value2, "esid");
			return (Criteria) this;
		}

		public Criteria andEsidNotBetween(String value1, String value2) {
			addCriterion("esid not between", value1, value2, "esid");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}