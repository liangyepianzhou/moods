package com.myproject.moods.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SaysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SaysExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSayIdIsNull() {
            addCriterion("say_id is null");
            return (Criteria) this;
        }

        public Criteria andSayIdIsNotNull() {
            addCriterion("say_id is not null");
            return (Criteria) this;
        }

        public Criteria andSayIdEqualTo(Long value) {
            addCriterion("say_id =", value, "sayId");
            return (Criteria) this;
        }

        public Criteria andSayIdNotEqualTo(Long value) {
            addCriterion("say_id <>", value, "sayId");
            return (Criteria) this;
        }

        public Criteria andSayIdGreaterThan(Long value) {
            addCriterion("say_id >", value, "sayId");
            return (Criteria) this;
        }

        public Criteria andSayIdGreaterThanOrEqualTo(Long value) {
            addCriterion("say_id >=", value, "sayId");
            return (Criteria) this;
        }

        public Criteria andSayIdLessThan(Long value) {
            addCriterion("say_id <", value, "sayId");
            return (Criteria) this;
        }

        public Criteria andSayIdLessThanOrEqualTo(Long value) {
            addCriterion("say_id <=", value, "sayId");
            return (Criteria) this;
        }

        public Criteria andSayIdIn(List<Long> values) {
            addCriterion("say_id in", values, "sayId");
            return (Criteria) this;
        }

        public Criteria andSayIdNotIn(List<Long> values) {
            addCriterion("say_id not in", values, "sayId");
            return (Criteria) this;
        }

        public Criteria andSayIdBetween(Long value1, Long value2) {
            addCriterion("say_id between", value1, value2, "sayId");
            return (Criteria) this;
        }

        public Criteria andSayIdNotBetween(Long value1, Long value2) {
            addCriterion("say_id not between", value1, value2, "sayId");
            return (Criteria) this;
        }

        public Criteria andSaywordsIsNull() {
            addCriterion("saywords is null");
            return (Criteria) this;
        }

        public Criteria andSaywordsIsNotNull() {
            addCriterion("saywords is not null");
            return (Criteria) this;
        }

        public Criteria andSaywordsEqualTo(String value) {
            addCriterion("saywords =", value, "saywords");
            return (Criteria) this;
        }

        public Criteria andSaywordsNotEqualTo(String value) {
            addCriterion("saywords <>", value, "saywords");
            return (Criteria) this;
        }

        public Criteria andSaywordsGreaterThan(String value) {
            addCriterion("saywords >", value, "saywords");
            return (Criteria) this;
        }

        public Criteria andSaywordsGreaterThanOrEqualTo(String value) {
            addCriterion("saywords >=", value, "saywords");
            return (Criteria) this;
        }

        public Criteria andSaywordsLessThan(String value) {
            addCriterion("saywords <", value, "saywords");
            return (Criteria) this;
        }

        public Criteria andSaywordsLessThanOrEqualTo(String value) {
            addCriterion("saywords <=", value, "saywords");
            return (Criteria) this;
        }

        public Criteria andSaywordsLike(String value) {
            addCriterion("saywords like", value, "saywords");
            return (Criteria) this;
        }

        public Criteria andSaywordsNotLike(String value) {
            addCriterion("saywords not like", value, "saywords");
            return (Criteria) this;
        }

        public Criteria andSaywordsIn(List<String> values) {
            addCriterion("saywords in", values, "saywords");
            return (Criteria) this;
        }

        public Criteria andSaywordsNotIn(List<String> values) {
            addCriterion("saywords not in", values, "saywords");
            return (Criteria) this;
        }

        public Criteria andSaywordsBetween(String value1, String value2) {
            addCriterion("saywords between", value1, value2, "saywords");
            return (Criteria) this;
        }

        public Criteria andSaywordsNotBetween(String value1, String value2) {
            addCriterion("saywords not between", value1, value2, "saywords");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andVarIsNull() {
            addCriterion("var is null");
            return (Criteria) this;
        }

        public Criteria andVarIsNotNull() {
            addCriterion("var is not null");
            return (Criteria) this;
        }

        public Criteria andVarEqualTo(String value) {
            addCriterion("var =", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarNotEqualTo(String value) {
            addCriterion("var <>", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarGreaterThan(String value) {
            addCriterion("var >", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarGreaterThanOrEqualTo(String value) {
            addCriterion("var >=", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarLessThan(String value) {
            addCriterion("var <", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarLessThanOrEqualTo(String value) {
            addCriterion("var <=", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarLike(String value) {
            addCriterion("var like", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarNotLike(String value) {
            addCriterion("var not like", value, "var");
            return (Criteria) this;
        }

        public Criteria andVarIn(List<String> values) {
            addCriterion("var in", values, "var");
            return (Criteria) this;
        }

        public Criteria andVarNotIn(List<String> values) {
            addCriterion("var not in", values, "var");
            return (Criteria) this;
        }

        public Criteria andVarBetween(String value1, String value2) {
            addCriterion("var between", value1, value2, "var");
            return (Criteria) this;
        }

        public Criteria andVarNotBetween(String value1, String value2) {
            addCriterion("var not between", value1, value2, "var");
            return (Criteria) this;
        }

        public Criteria andTimesIsNull() {
            addCriterion("times is null");
            return (Criteria) this;
        }

        public Criteria andTimesIsNotNull() {
            addCriterion("times is not null");
            return (Criteria) this;
        }

        public Criteria andTimesEqualTo(Date value) {
            addCriterionForJDBCDate("times =", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotEqualTo(Date value) {
            addCriterionForJDBCDate("times <>", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThan(Date value) {
            addCriterionForJDBCDate("times >", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("times >=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThan(Date value) {
            addCriterionForJDBCDate("times <", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("times <=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesIn(List<Date> values) {
            addCriterionForJDBCDate("times in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotIn(List<Date> values) {
            addCriterionForJDBCDate("times not in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("times between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("times not between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
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