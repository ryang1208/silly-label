import { IPageProps } from 'declare/CommonInterface'
import { LoginPageModel } from 'router/LoginPage/LoginPageModel'

export interface ILoginPageProps extends IPageProps {
  loginPageModel: LoginPageModel
}
