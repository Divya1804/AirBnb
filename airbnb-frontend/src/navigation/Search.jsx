import React from 'react'
import {BiSearch} from 'react-icons/bi'

const Search = () => {
  return (
    <div className='border-[1px] w-full md:w-auto py-2 rounded-full shadow-sm hover:shadow-md ease-in transition duration-75  cursor-pointer'>
        <div className='flex flex-row items-center justify-between '>
            <div className='text-sm font-semibold px-6'>
                Anywhere
            </div>
            <div className='hidden sm:block text-sm font-semibold px-6 border-x-[1px] text-center'>
                Any week
            </div>
            <div className='text-sm pl-6 pr-2 text-gray-600 flex fle-row items-center gap-3 '>
                <div className='hidden sm:block'>Add guests</div>
                <div className='p-2 bg-rose-500 rounded-full text-white'>
                    <BiSearch size={'18px'} />
                </div>
            </div>
        </div>
    </div>
  )
}

export default Search
