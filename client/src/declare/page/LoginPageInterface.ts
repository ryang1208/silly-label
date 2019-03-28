import { IPageProps } from 'declare/CommonInterface'
import { LoginPageModel } from 'router/LoginPage/LoginPageModel'

export interface ILoginPageInterfaceProps extends IPageProps {
  loginPageModel: LoginPageModel
}
