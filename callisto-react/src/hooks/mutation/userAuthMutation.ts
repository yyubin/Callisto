import api from "@/libs/axios/api";
import token from "@/libs/token";
import {
  LoginRequest,
  LoginResponse,
  SignUpRequest,
  SignUpResponse,
} from "@/models/api/auth";
import API_PATH from "@/utils/path/api";
import Path from "@/utils/path/routes";
import { useMutation, useQueryClient } from "@tanstack/react-query";

const { API_LOGIN, API_SIGNUP } = API_PATH;
const { HOME, LOGIN } = Path;

// 로그인
const loginFetcher = (reqData: LoginRequest) => {
  return api
    .post<LoginResponse>(API_LOGIN, reqData)
    .then(({ data }) => {
      token.set(data.token);
    })
    .catch(console.error);
};

export const useUserLoginMutation = () => {
  const queryClient = useQueryClient();

  return useMutation(loginFetcher, {
    onError: (error) => {
      return alert(error);
    },
    onSuccess: () => {
      if (token.get() == null || token.get()?.length === 0) {
        return alert("인가되지 않은 사용자입니다.");
      }
      // router.push(HOME);
      queryClient.invalidateQueries<string>(["auth"]);
    },
  });
};

// 회원가입
const signUpFetcher = (reqData: SignUpRequest) => {
  return api
    .post<SignUpResponse>(API_SIGNUP, reqData)
    .then(({ data }) => {
      if (data.success === false) return alert("중복된 아이디 입니다.");
      alert("회원가입 되었습니다.");
    })
    .catch(console.error);
};

export const useUserSignUpMutation = () => {
  const queryClient = useQueryClient();

  return useMutation(signUpFetcher, {
    onError: (error) => {
      return error;
    },
    onSuccess: () => {
      queryClient.invalidateQueries<string>(["auth"]);
      // router.push(LOGIN);
    },
  });
};
