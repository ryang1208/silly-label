'use strict'

import * as React from 'react'
import { inject, observer } from 'mobx-react'
import { HelloPageModel } from './HelloPageModel'

@inject('helloPageModel')
@observer
export default class HelloPage extends React.Component<
  {
    helloPageModel: HelloPageModel
  },
  {}
> {
  render() {
    return (
      <div className="hello-container">
        this is hello page
        <p>model: {this.props.helloPageModel.modelName}</p>
      </div>
    )
  }
}
