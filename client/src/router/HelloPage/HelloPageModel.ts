import { observable, action } from 'mobx'

export class HelloPageModel {
  @observable modelName: string = 'helloModel'

  @action
  reset() {
    this.modelName = 'helloModel'
  }
}

const helloPageModel = new HelloPageModel()
export default helloPageModel
