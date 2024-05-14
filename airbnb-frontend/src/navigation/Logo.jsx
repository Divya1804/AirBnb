import React from 'react'
import Image1 from '../assets/Airbnb-logo.jpg'

const Logo = () => {
  return (
    <div>
      <img src={Image1} alt="" height={"100px"} width={"100px"} className='md:block cursor-pointer'/>
    </div>
  )
}

export default Logo
