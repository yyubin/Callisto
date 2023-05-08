import LoginForm from "@/components/auth/login/LoginForm";

const Login = () => {
  return (
    <div className="w-full flex flex-col gap-2 items-center justify-center">
      <section className="w-[80vw] flex flex-col bg-white rounded-md shadow-t-sm">
        <LoginForm />
      </section>
    </div>
  );
};

export default Login;
