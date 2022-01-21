package adapters;

import com.google.common.reflect.TypeToken;
import models.*;

public class CaseAdapter extends BaseAdapter {
    final String CASE_URI = "case/";

    public CaseResponseBody getAllCases(String projectCode, int expectedStatusCode) {
        return gson.fromJson(get(CASE_URI + projectCode, expectedStatusCode), new TypeToken<CaseResponseBody<AllCases>>() {
        }.getType());
    }

    public CaseResponseBody getCase(String projectCode, String idCase, int expectedStatusCode) {
        return gson.fromJson(get(CASE_URI + projectCode + "/" + idCase, expectedStatusCode), new TypeToken<CaseResponseBody<Case>>() {
        }.getType());
    }

    public CaseResponseBody createCase(String projectCode, Case testCase) {
        return gson.fromJson(post(CASE_URI + projectCode, gson.toJson(testCase), 200), new TypeToken<CaseResponseBody<ResultCode>>() {
        }.getType());
    }

    public CaseResponseBody deleteCase(String projectCode, String idCase) {
        return gson.fromJson(delete(CASE_URI + projectCode + "/" + idCase, gson.toJson(projectCode), 200),
                new TypeToken<CaseResponseBody<ResultCode>>() {
                }.getType());
    }
}
